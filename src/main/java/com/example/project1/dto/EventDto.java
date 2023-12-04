package com.example.project1.dto;

import java.util.Date;
import java.util.UUID;

public class EventDto {
    private UUID id;
    private String title;
    private String shortDescription;
    private Date eventDate;
    private Date eventRegistrationCloseDate;

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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventRegistrationCloseDate() {
        return eventRegistrationCloseDate;
    }

    public void setEventRegistrationCloseDate(Date eventRegistrationCloseDate) {
        this.eventRegistrationCloseDate = eventRegistrationCloseDate;
    }

}
