import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequest {

    private int requestID;
    private String description;
    private LocalDateTime createdAt;
    private RequestStatus status;

    private Reservation reservation;
    private Manager pm;
    private Provider assignedTo;
    private List<ServiceOffer> offers;

    // ---------------- constructors ----------------

    public ServiceRequest() {
        this.createdAt = LocalDateTime.now();
        this.status = RequestStatus.NEW;
        this.offers = new ArrayList<>();
    }

    public ServiceRequest(String description,
                          Reservation reservation,
                          Manager pm) {
        this();
        this.description = description;
        this.reservation = reservation;
        this.pm = pm;
    }

    // ---------------- getters ----------------

    public int getRequestID() {
        return requestID;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public ProjectManager getPm() {
        return pm;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public List<ServiceOffer> getOffers() {
        return offers;
    }

    // ---------------- setters ----------------

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setPm(Manager pm) {
        this.pm = pm;
    }

    // ---------------- business methods ----------------

    public void assignToProvider(Provider provider) {
        this.assignedTo = provider;
        this.status = RequestStatus.ASSIGNED;
    }

    public void changeStatus(RequestStatus status) {
        this.status = status;
    }

    public void addOffer(ServiceOffer offer) {
        if (offer != null)
            offers.add(offer);
    }

    public String getRequestDetails() {
        return "Request ID: " + requestID +
               "\nDescription: " + description +
               "\nStatus: " + status +
               "\nReservation: " + reservation.getReservationNumber() +
               "\nCreated At: " + createdAt;
    }
}
