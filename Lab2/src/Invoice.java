/*
 * Invoice.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
public class Invoice {
    private String date;
    private Booking booking;
    private boolean statusPaid;
    private Client client;

    public Invoice(Client client, String date, Booking booking, boolean paid) {
        this.client = client;
        this.date = date;
        this.booking = booking;
        this.statusPaid = paid;
    }

    public boolean getStatusPaid() {
        return this.statusPaid;
    }

    public String getDate() {
        return this.date;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setStatusPaid(boolean paid) {
        this.statusPaid = paid;
    }

    public Client getClient() {
        return this.client;
    }
}
