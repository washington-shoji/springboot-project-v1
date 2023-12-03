package com.example.project1.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    boolean existsByTitle(String title);

    Optional<Event> findById(UUID id);
}
