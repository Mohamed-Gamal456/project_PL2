import java.time.LocalDateTime;
public class Event {

    private int eventID;
    private String title;
    private String notes;
    private int attendeesCount;
    private String location;
    private LocalDateTime date;

    // ---------------- constructors ----------------

    public Event() {
    }

    public Event(int eventID, String title, String notes,
                 int attendeesCount, String location,
                 LocalDateTime date) {
        this.eventID = eventID;
        this.title = title;
        this.notes = notes;
        this.attendeesCount = attendeesCount;
        this.location = location;
        this.date = date;
    }

    // ---------------- getters ----------------

    public int getEventID() {
        return eventID;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

    public int getAttendeesCount() {
        return attendeesCount;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // ---------------- setters ----------------

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAttendeesCount(int attendeesCount) {
        this.attendeesCount = attendeesCount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // ---------------- business methods ----------------

    public String getDetails() {
        return "Event ID: " + eventID +
               "\nTitle: " + title +
               "\nNotes: " + notes +
               "\nAttendees: " + attendeesCount +
               "\nLocation: " + location +
               "\nDate: " + date;
    }
}
