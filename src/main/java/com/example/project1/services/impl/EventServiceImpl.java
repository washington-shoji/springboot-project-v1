package com.example.project1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entities.Event;
import com.example.project1.repositories.EventRepository;
import com.example.project1.services.EventService;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    @Autowired
    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = repository.findAll();
        return events;
    }

    @Override
    public Event findById(Long id) {
        return findEventById(id);
    }

    @Override
    public Event saveEvent(Event request) {
        try {
            if (repository.existByTitle(request.getTitle())) {
                throw new IllegalArgumentException(
                        "Event Title " + request.getTitle() + " already exists, please select another title");
            }

            Event event = new Event();
            event.setTitle(request.getTitle());
            event.setShortDescription(request.getShortDescription());

            Event savedEvent = repository.save(event);

            return savedEvent;

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Event updateEvent(Long id, Event request) {
        try {
            Event existingEvent = findEventById(request.getId());
            if (!existingEvent.getTitle().equals(request.getTitle())
                    && !repository.existByTitle(request.getTitle())) {
                throw new IllegalArgumentException(
                        "Event Title " + request.getTitle() + " already exists, please select another title");
            }

            existingEvent.setTitle(request.getTitle());
            existingEvent.setShortDescription(request.getShortDescription());

            Event updatedEvent = repository.save(existingEvent);
            return updatedEvent;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void deleteEvent(Long id) {
        Event existEvent = findEventById(id);
        repository.deleteById(existEvent.getId());
    }

    private Event findEventById(Long id) {
        Event existEvent = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find an existing event."));
        return existEvent;
    }

}
