/*
 * Client.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private List<Invoice> invoices;

    public Client(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.invoices= new ArrayList<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNum() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }
    
    public List<Invoice> getInvoice(){
    	return this.invoices;
    
    }

    public void setFirstName(String fName) {
        this.firstName=fName;
    }

    public void setLastName(String lName) {
        this.lastName=lName;
    }

    public void setPhoneNum(String num) {
        this.phoneNumber=num;
    }

    public void setAddress(String address) {
        this.address=address;    
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices=invoices;
    }
}
