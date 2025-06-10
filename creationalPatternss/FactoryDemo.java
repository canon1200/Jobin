package creationalPatternss;

// Product interface
interface Notification {
    void notifyUser();
}

// Concrete Products
class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Push Notification");
    }
}

// Factory
class NotificationFactory {
    public static Notification createNotification(String type) {
        if ("email".equalsIgnoreCase(type)) {
            return new EmailNotification();
        } else if ("sms".equalsIgnoreCase(type)) {
            return new SMSNotification();
        } else if ("push".equalsIgnoreCase(type)) {
            return new PushNotification();
        } else {
            return null;
        }
    }
}

// Main
public class FactoryNotificationDemo {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.createNotification("email");
        n1.notifyUser();

        Notification n2 = NotificationFactory.createNotification("sms");
        n2.notifyUser();

        Notification n3 = NotificationFactory.createNotification("push");
        n3.notifyUser();
    }
}
