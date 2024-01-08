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
    String eventImageUrl;

    @Column(nullable = false)
    String eventImagePublicId;

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

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImage) {
        this.eventImageUrl = eventImage;
    }

    public String getEventImagePublicId() {
        return eventImagePublicId;
    }

    public void setEventImagePublicId(String eventImagePublicId) {
        this.eventImagePublicId = eventImagePublicId;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", eventImageUrl="
                + eventImageUrl + ", eventImagePublicId=" + eventImagePublicId + ", eventDate=" + eventDate
                + ", eventRegistrationCloseDate=" + eventRegistrationCloseDate + "]";
    }

}
