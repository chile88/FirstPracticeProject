package data.definition;

public class HistoryRecord {
    String orderReference;
    String date;
    String price;

    public HistoryRecord setOrderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }

    public HistoryRecord setDate(String date) {
        this.date = date;
        return this;
    }

    public HistoryRecord setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

}
