import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Reservation> reservations;

    public Customer() {
        super();
        reservations = new ArrayList<>();
    }

    public Customer(int id, String name, String email,
                    String phone, String password) {
        super(id, name, email, phone, password);
        reservations = new ArrayList<>();
    }

    // ---------------- reservations ----------------

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation res) {
        if (res != null)
            reservations.add(res);
    }

    public void removeReservation(Reservation res) {
        reservations.remove(res);
    }

    public Reservation viewReservation(int reservationID) {
        for (Reservation r : reservations) {
            if (r.getReservationID() == reservationID)
                return r;
        }
        return null;
    }

    public void cancelReservation(int reservationID) {
        Reservation r = viewReservation(reservationID);
        if (r != null)
            r.updateStatus(ReservationStatus.CANCELLED);
    }

    // ---------------- system actions ----------------

    public void createAccount() {
        UserRepository.save(this);
    }

    public Reservation bookEvent(Event event) {

        Reservation res = new Reservation(event, this);
        reservations.add(res);
        return res;
    }

    public void manageBooking(int reservationID) {
        Reservation r = viewReservation(reservationID);
        if (r != null)
            System.out.println(r.getReservationInfo());
    }

    public void contactPM(Manager pm, String message) {
        if (pm != null)
            pm.contactCustomer(this, message);
    }
}
