//  Purpose: Demonstrate the Decorator Pattern.

//  This example of the Decorator Pattern is a simple notification system.
interface Notification {
    public void sendNotification(String message);
}

// BasicNotification is the concrete component class.
class BasicNotification implements Notification {
    
    @Override
    public void sendNotification(String message) {
        System.out.println("Basic Notification: " + message);
    }
}

// NotificationDecorator is the decorator class.
// It implements the Notification interface and has a Notification object.
abstract class NotificationDecorator implements Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void sendNotification(String message) {
        notification.sendNotification(message);
    }
}

// EmailNotification, SMSNotification and NotificationApp are the concrete decorator classes.
// They extend NotificationDecorator and add their own functionality.
class EmailNotification extends NotificationDecorator {
    public EmailNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("Sending Email Notification: " + message);
    }
}

class SMSNotification extends NotificationDecorator {
    public SMSNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("Sending SMS Notification: " + message);
    }
}

class NotificationApp extends NotificationDecorator {
    public NotificationApp(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("Sending Notification via App: " + message);
    }
}

// Decorator is the client class
// It creates a BasicNotification object and then wraps it with the decorator objects.
public class Decorator {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification(new BasicNotification());
        emailNotification.sendNotification("This is a test email notification");
        System.out.println();

        Notification smsNotification = new SMSNotification(new BasicNotification());
        smsNotification.sendNotification("This is a test SMS notification");
        System.out.println();

        Notification appNotification = new NotificationApp(new BasicNotification());
        appNotification.sendNotification("This is a test notification via App");
        System.out.println();

        // Decorators can be stacked on top of each other.
        Notification emailSmsNotification = new EmailNotification(new SMSNotification(new BasicNotification()));
        emailSmsNotification.sendNotification("This is a test email and SMS notification");
        System.out.println();

        // Decorators can be stacked like this because they all implement the Notification interface.
        Notification emailSmsAppNotification = new EmailNotification(new SMSNotification(new NotificationApp(new BasicNotification())));
        emailSmsAppNotification.sendNotification("This is a multiplatform notification");
    }
}