package org.delta.notification.persons;

public class NotifyCustomerEvent {
    private NotificationData notificationData;

    public NotifyCustomerEvent(NotificationData notificationData) {
        this.notificationData = notificationData;
    }

    public NotificationData getNotificationData() {
        return notificationData;
    }
}
