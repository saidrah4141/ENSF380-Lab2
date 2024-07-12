/*
 * Pet.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private String species;
    private String color;
    private String breed;
    private Client owner;
    private Employee careTaker;
    private CareProfile care;
    private boolean livingStatus;
    private List<Treatment> treatments;

    public Pet(String name, String species, String color, String breed, CareProfile care) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.breed = breed;
        this.care=care;
        this.treatments= new ArrayList<>();
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Client getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getColor() {
        return this.color;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setEmployee(Employee employee) {
        this.careTaker = employee;
    }

    public Employee getEmployee() {
        return this.careTaker;
    }

    public void setCare(CareProfile care) {
        this.care = care;
    }

    public CareProfile getCare() {
        return this.care;
    }

    public void setLivingStatus(boolean alive) {
        this.livingStatus = alive;
    }

    public boolean getLivingStatus() {
        return this.livingStatus;
    }

    public List<Treatment> getTreatments() {
        return this.treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
