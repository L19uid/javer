package org.delta.notification.persons;

public class NotificationData {
    String fullName;
    String accountNumber;

    public NotificationData(String accountNumber, String fullName) {
        this.accountNumber = accountNumber;
        this.fullName = fullName;
    }

    String getCustomerName() {
        return fullName;
    }
}
