public class BillItem {

    private String description;
    private double price;

    public BillItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getItem() {
        return description + " : " + price;
    }
}
