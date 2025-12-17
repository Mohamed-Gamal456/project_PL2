import java.time.LocalDateTime;

enum NotificationType {
    INFO,
    WARNING,
    ERROR,
    SUCCESS
}

public class Notification {
    private int id;
    private String to;
    private NotificationType type;
    private String message;
    private LocalDateTime sentAt;

    public Notification() {
        this.sentAt = LocalDateTime.now();
    }

    public Notification(int id, String to, NotificationType type, String message) {
        this.id = id;
        this.to = to;
        this.type = type;
        this.message = message;
        this.sentAt = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public int getId() {
        return id;
    }

    public String getTo() {
        return to;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void send() {
        System.out.println("Sending notification to " + to);
        System.out.println("Type: " + type);
        System.out.println("Message: " + message);
        System.out.println("Sent at: " + sentAt);
    }

    public String getNotification() {
        return "Notification [id=" + id + ", to=" + to + ", type=" + type 
                + ", message=" + message + ", sentAt=" + sentAt + "]";
    }
}
