package org.delta.notification.persons;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Singleton;

@Singleton
public class NotifyCustomerEventListener {
    @Subscribe
    public void notifyCustomer(NotifyCustomerEvent event) {
        System.out.println("Call event: " + event.getNotificationData().getCustomerName());
    }
}
