package com.example.project1.services;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.example.project1.entities.Event;

public interface EventService {
    List<Event> findAll();

    Event findById(UUID id);

    Event saveEvent(Event event, MultipartFile multipartFile);

    Event updateEvent(UUID id, Event event, MultipartFile multipartFile);

    void deleteEvent(UUID id);
}
