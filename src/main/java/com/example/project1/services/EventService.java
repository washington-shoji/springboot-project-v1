package com.example.project1.services;

import java.util.List;

import com.example.project1.entities.Event;

public interface EventService {
    List<Event> findAll();

    Event findById(Long id);

    Event saveEvent(Event event);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);
}
