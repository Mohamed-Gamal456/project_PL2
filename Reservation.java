import java.time.LocalDateTime;

public class Reservation {

    private int reservationID;
    private String reservationNumber;
    private LocalDateTime createdAt;
    private ReservationStatus status;

    private Event eventDetails;
    private Customer customer;
    private Bill bill;

    // ---------------- constructors ----------------

    public Reservation() {
        this.createdAt = LocalDateTime.now();
        this.status = ReservationStatus.PENDING;
    }

    public Reservation(Event eventDetails, Customer customer) {
        this();
        this.eventDetails = eventDetails;
        this.customer = customer;
        this.reservationNumber = generateReservationNumber();
    }

    // ---------------- getters ----------------

    public int getReservationID() {
        return reservationID;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public Event getEventDetails() {
        return eventDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bill getBill() {
        return bill;
    }

    // ---------------- setters ----------------

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setEventDetails(Event eventDetails) {
        this.eventDetails = eventDetails;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    // ---------------- business methods ----------------

    public void updateStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getReservationInfo() {
        return "Reservation #" + reservationNumber +
               "\nCustomer: " + customer.getName() +
               "\nEvent: " + eventDetails.getTitle() +
               "\nStatus: " + status +
               "\nCreated At: " + createdAt;
    }

    private String generateReservationNumber() {
        return "RES-" + System.currentTimeMillis();
    }
}
