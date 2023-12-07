package com.example.project1.dto;

import java.util.UUID;

public class EventDto {
    private UUID id;
    private String title;
    private String shortDescription;
    private String eventImage;
    private String eventDate;
    private String eventRegistrationCloseDate;

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

    public void setEventRegistrationCloseDate(String eventRegistrationCloseDate) {
        this.eventRegistrationCloseDate = eventRegistrationCloseDate;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    @Override
    public String toString() {
        return "EventDto [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", eventImage="
                + eventImage + ", eventDate=" + eventDate + ", eventRegistrationCloseDate=" + eventRegistrationCloseDate
                + "]";
    }

}
