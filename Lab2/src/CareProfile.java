/*
 * CareProfile.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
import java.util.Arrays;

public class CareProfile {
    private String dietaryRestrictions;
    private String[] medicationList;
    private String medicationInstruction;

    public CareProfile(String diet, String[] medList, String instructions) {
        this.dietaryRestrictions = diet;
        this.medicationList = medList;
        this.medicationInstruction = instructions;
    }

    public void setMedicationList(String[] medList) {
        this.medicationList = medList;
    }
    
    

    public String getCareInstructions() {
    	String careInstructions = "Dietary Restrictions: " + this.dietaryRestrictions + "\n";
        careInstructions += "Medication List:\n";
        for (String med : this.medicationList) {
            careInstructions += "- " + med + "\n";
        }
        careInstructions += "Medication Instructions: " + this.medicationInstruction;
        return careInstructions;
    }
}
