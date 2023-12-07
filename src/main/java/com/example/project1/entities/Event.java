package com.example.project1.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String shortDescription;

    @Column(nullable = false)
    String eventImage;

    @Column(nullable = false)
    String eventDate;

    @Column(nullable = false)
    String eventRegistrationCloseDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventRegistrationCloseDate() {
        return eventRegistrationCloseDate;
    }

    public void setEventRegistrationCloseDate(String eventRegistrationClose) {
        this.eventRegistrationCloseDate = eventRegistrationClose;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", eventImage="
                + eventImage + ", eventDate=" + eventDate + ", eventRegistrationCloseDate=" + eventRegistrationCloseDate
                + "]";
    }

}
