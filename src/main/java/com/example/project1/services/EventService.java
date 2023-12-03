package com.example.project1.services;

import java.util.List;
import java.util.UUID;

import com.example.project1.entities.Event;

public interface EventService {
    List<Event> findAll();

    Event findById(UUID id);

    Event saveEvent(Event event);

    Event updateEvent(UUID id, Event event);

    void deleteEvent(UUID id);
}
