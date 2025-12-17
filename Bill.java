import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private int billID;
    private Reservation reservation;
    private LocalDateTime issuedAt;
    private List<BillItem> items = new ArrayList<>();

    public Bill(int billID, Reservation reservation) {
        this.billID = billID;
        this.reservation = reservation;
        this.issuedAt = LocalDateTime.now();
    }

    public void addItem(BillItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(BillItem::getPrice).sum();
    }

    public String getBillDetails() {
        return "Bill #" + billID +
                "\nReservation: " + reservation.getReservationNumber() +
                "\nTotal: " + calculateTotal();
    }
}
