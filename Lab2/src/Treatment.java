/*
 * Treatment.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
public class Treatment {
    private Pet pet;
    private String treatmentDetails;
    private String date;
    private Employee employee;

    public Treatment(Pet pet, String details, String date, Employee emp) {
        this.pet = pet;
        this.treatmentDetails = details;
        this.date = date;
        this.employee = emp;
    }

    public String getTreatmentDetails() {
        return "Treatment provided to " +this.pet.getName()+ " on " + this.date + " by " + this.employee.getFirstName() + ": " + this.treatmentDetails;
    }

}
