package com.example.project1.services.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.project1.entities.Event;
import com.example.project1.repositories.EventRepository;
import com.example.project1.services.EventService;

@Service
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final MediaFileUploadServiceImpl mediaFileUploadService;

    @Autowired
    public EventServiceImpl(
            EventRepository repository,
            MediaFileUploadServiceImpl mediaFileUploadService) {
        this.repository = repository;
        this.mediaFileUploadService = mediaFileUploadService;
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = repository.findAll();
        return events;
    }

    @Override
    public Event findById(UUID id) {
        return findEventById(id);
    }

    @Override
    @Transactional
    public Event saveEvent(Event request, MultipartFile multipartFile) {
        try {
            if (repository.existsByTitle(request.getTitle())) {
                throw new IllegalArgumentException(
                        "Event Title " + request.getTitle() + " already exists, please select another title");
            }

            Map imageData = mediaFileUploadService.uploadFile(multipartFile);

            System.out.println(imageData);

            Event event = new Event();
            event.setTitle(request.getTitle());
            event.setShortDescription(request.getShortDescription());
            event.setEventImageUrl(imageData.get("url").toString());
            event.setEventImagePublicId(imageData.get("public_id").toString());
            event.setEventDate(request.getEventDate());
            event.setEventRegistrationCloseDate(request.getEventRegistrationCloseDate());

            Event savedEvent = repository.save(event);

            return savedEvent;

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Event updateEvent(UUID id, Event request, MultipartFile multipartFile) {
        try {
            Event existingEvent = findEventById(request.getId());
            if (!existingEvent.getTitle().equals(request.getTitle())
                    && repository.existsByTitle(request.getTitle())) {
                throw new IllegalArgumentException(
                        "Event Title " + request.getTitle() + " already exists, please select another title");
            }

            if (multipartFile != null) {
                mediaFileUploadService.deletImage(existingEvent.getEventImagePublicId());

                Map imageData = mediaFileUploadService.uploadFile(multipartFile);
                existingEvent.setEventImageUrl(imageData.get("url").toString());
            }

            existingEvent.setTitle(request.getTitle());
            existingEvent.setShortDescription(request.getShortDescription());
            existingEvent.setEventDate(request.getEventDate());
            existingEvent.setEventRegistrationCloseDate(request.getEventRegistrationCloseDate());

            Event updatedEvent = repository.save(existingEvent);
            return updatedEvent;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteEvent(UUID id) {
        Event existEvent = findEventById(id);
        repository.deleteById(existEvent.getId());
    }

    private Event findEventById(UUID id) {
        Event existEvent = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find an existing event."));
        return existEvent;
    }

}
