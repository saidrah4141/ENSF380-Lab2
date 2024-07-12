/*
 * DeathCertificate.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
public class DeathCertificate {
    private Pet pet;
    private String date;
    private String cause;

    public DeathCertificate(Pet pet, String date, String cause) {
        this.pet = pet;
        this.date = date;
        this.cause = cause;
    }

    

    public String getDetails() {
        return (this.pet.getName()+ " passed away on " + this.date + 
        		" due to " + this.cause);
    }

}
