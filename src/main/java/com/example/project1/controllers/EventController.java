package com.example.project1.controllers;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project1.dto.EventDto;
import com.example.project1.entities.Event;
import com.example.project1.services.impl.EventServiceImpl;

@RestController
@RequestMapping("event")
public class EventController {

    private final EventServiceImpl eventService;
    private final ModelMapper modelMapper;

    @Autowired
    public EventController(
            EventServiceImpl eventService,
            ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    List<EventDto> getAllEvents() {
        List<Event> events = eventService.findAll();
        return events.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/by-id")
    EventDto getEventById(@RequestParam(value = "id") UUID id) {
        Event event = eventService.findById(id);
        return convertToDto(event);
    }

    @PostMapping("/create")
    EventDto createEvent(@ModelAttribute EventDto eventDto,
            @RequestParam("image") MultipartFile multipartFile) {
        Event event = converteToEntity(eventDto);
        Event eventCreated = eventService.saveEvent(event, multipartFile);
        return convertToDto(eventCreated);
    }

    @PutMapping("/update")
    EventDto upddateEvent(@RequestParam(value = "id") UUID id, @ModelAttribute EventDto eventDto,
            @RequestParam("image") MultipartFile multipartFile) {
        if (!Objects.equals(id, eventDto.getId())) {
            throw new IllegalArgumentException("Ids don't match");
        }
        Event event = converteToEntity(eventDto);
        Event updatedEvent = eventService.updateEvent(id, event, multipartFile);
        return convertToDto(updatedEvent);
    }

    @DeleteMapping("/delete")
    void deleteEvent(@RequestParam(value = "id") UUID id) {
        eventService.deleteEvent(id);
    }

    private EventDto convertToDto(Event event) {
        EventDto eventRequestDto = modelMapper.map(event, EventDto.class);
        return eventRequestDto;
    }

    private Event converteToEntity(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        return event;
    }

}
