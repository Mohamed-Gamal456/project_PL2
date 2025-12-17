import java.time.LocalDateTime;

public class ServiceOffer {

    private int offerID;
    private boolean accepted;
    private double price;
    private LocalDateTime readyDate;

    private Provider provider;
    private ServiceRequest request;

    // ---------------- constructors ----------------

    public ServiceOffer() {
        this.accepted = false;
    }

    public ServiceOffer(boolean accepted,
                        double price,
                        Provider provider,
                        ServiceRequest request) {
        this.accepted = accepted;
        this.price = price;
        this.provider = provider;
        this.request = request;
    }

    // ---------------- getters ----------------

    public int getOfferID() {
        return offerID;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getReadyDate() {
        return readyDate;
    }

    public Provider getProvider() {
        return provider;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    // ---------------- setters ----------------

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setRequest(ServiceRequest request) {
        this.request = request;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setReadyDate(LocalDateTime readyDate) {
        this.readyDate = readyDate;
    }

    // ---------------- business methods ----------------

    public void acceptOffer() {
        this.accepted = true;
        if (request != null)
            request.changeStatus(RequestStatus.APPROVED);
    }

    public void rejectOffer() {
        this.accepted = false;
        if (request != null)
            request.changeStatus(RequestStatus.REJECTED);
    }

    public String getOfferDetails() {
        return "Offer ID: " + offerID +
               "\nProvider: " + provider.getName() +
               "\nPrice: " + price +
               "\nReady Date: " + readyDate +
               "\nAccepted: " + accepted;
    }
}
