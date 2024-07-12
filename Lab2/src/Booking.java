/*
 * Booking.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
public class Booking {
    private String date;
    private String length;
    private Employee assignedEmp;
    private Pet pet;
    private int bookingID;
    private static int idCounter = 1; 

    public Booking(String date, String length, Employee emp, Pet pet) {
        this.date = date;
        this.length = length;
        this.assignedEmp = emp;
        this.pet = pet;
        this.bookingID = idCounter++;
    }

    public String getDate() {
        return this.date;
    }

    public String getLength() {
        return this.length;
    }

    public Employee getEmp() {
        return this.assignedEmp;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setEmp(Employee emp) {
        this.assignedEmp = emp;
    }

    public int getBookingID() {
        return this.bookingID;
    }
}
