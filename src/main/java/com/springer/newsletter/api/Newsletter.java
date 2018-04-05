package com.springer.newsletter.api;

import java.io.Serializable;
import java.util.List;

public class Newsletter implements Serializable {
    private String recipient;
    private List<BookFeed> notifications;

    public Newsletter()
    {
    }

    public Newsletter(String recipient, List<BookFeed> notifications)
    {
        this.recipient = recipient;
        this.notifications = notifications;
    }

    public String getRecipient() {
        return recipient;
    }

    public List<BookFeed> getNotifications() {
        return notifications;
    }
}
