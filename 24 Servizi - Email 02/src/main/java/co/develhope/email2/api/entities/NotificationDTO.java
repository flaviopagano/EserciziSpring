package co.develhope.email2.api.entities;

import lombok.Data;

@Data
public class NotificationDTO {
    private String contactId;
    private String title;
    private String text;
}
