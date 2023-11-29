package com.example.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existByTitle(String title);
}
