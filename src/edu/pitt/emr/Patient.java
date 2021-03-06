package edu.pitt.emr;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//import Diagnoses;
//import Medication;

public class Patient extends User {

    /**
     * Faheem Siddiqui This class is for the classifications of a Patient Made
     * the specific modifications for HW 5 And Stated what I used from HW 4
     * 
     * added the Overide Method on the bottom of this class
     */

    private String patientID;
    private String firstName; // First name of Patient
    private String lastName; // Last Name of Patient
    private String ssn; // Social security of patient

    private char gender; // the Gender of Patient (M) male (F) Female

    private ArrayList<Diagnoses> diagnoses = new ArrayList<Diagnoses>(); // changed
                                                                         // to
                                                                         // Array
                                                                         // list
                                                                         // for
                                                                         // Diagnoses

    private ArrayList<Medication> medication = new ArrayList<Medication>(); // change
                                                                            // to
                                                                            // Array
                                                                            // List
                                                                            // for
                                                                            // Medication

    private ArrayList<String> symptom = new ArrayList<String>(); // the Symptoms
                                                                 // of the
                                                                 // Patient
                                                                 // changed to
                                                                 // array

    private double weight; // the Weight of the Patient
    private double height; // the Height of the Patient

    public Patient(String firstName, String lastName, String ssn, char gender,
            double weight, double height) {
        super(firstName, lastName, ssn, gender);

        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        // Build patientID. Replace dashes with empty strings (strip dashes) //
        // copied from hw solutions
        this.patientID = ssn.replace("-", "");
        // Strip spaces
        this.patientID = this.patientID.replace(" ", "");
        // Concatenate first letter of the first and last name to patientID

        String name = this.firstName + this.lastName;
        for (int i = 0; i < name.length(); i++) {

            if ((name.charAt(i) != 'a') && (name.charAt(i) != 'e')
                    && (name.charAt(i) != 'i') && (name.charAt(i) != 'o')
                    && (name.charAt(i) != 'u')) {
                patientID = patientID + name.charAt(i);

            }
        }

    } // end of First name, last name, ssn, gender, weight, height

    /*
     * public Patient(String firstName2, String lastName2, String ssn2, //auto
     * generated might have to delete String string, String string2, String
     * string3) { // TODO Auto-generated constructor stub }
     */

    public double calculateBMI() { // using this from hw solutions
        final int BMI_FORMULA_FACTOR = 703;
        double BMI = this.weight / Math.pow(this.height, 2)
                * BMI_FORMULA_FACTOR;
        return BMI;

    } // end of Calculating BMI

    /**
     * This is the get profile method If user enters something the doctor does
     * not know then it will print null, until they enter something that is
     * usefull
     * 
     * @return
     */
    public String getProfile() {
        String patientProfile = "Name: " + this.lastName + ", "
                + this.firstName + "\n";
        patientProfile = patientProfile + "Patient ID: " + this.patientID
                + "\n";
        patientProfile = patientProfile + "BMI: " + this.calculateBMI() + "\n";

        if (this.getDiagnoses().size() != 0) {
            for (Diagnoses d : this.getDiagnoses()) {

                if (d != null) {
                    patientProfile = patientProfile + "Diagnoses: "
                            + d.getName() + "\n";
                } else {
                    patientProfile = patientProfile + "Diagnoses: none\n";
                }
            } // end of Enhanced for loop for Diagnoses
        }

        if (this.getMedication().size() != 0) {

            for (Medication m : this.getMedication()) {

                if (m != null) {
                    patientProfile = patientProfile + "Medication: "
                            + m.getName() + "\n";
                } else {
                    patientProfile = patientProfile + "Medication: none\n";
                }
            } // end of Enhanced for loop for Medication
        }

        JOptionPane.showMessageDialog(null, patientProfile);
        return patientProfile;

    } // end of Get Profile method

    /**
     * Getters and setters for Patient class
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * public Diagnoses getDiagnoses() { return diagnoses; }
     * 
     * public void setDiagnoses(Diagnoses diagnoses) { this.diagnoses =
     * diagnoses; }
     * 
     * public Medication getMedication() { return medication; }
     * 
     * public void setMedication(Medication medication) { this.medication =
     * medication; }
     * 
     * public String getSymptom() { return symptom; }
     * 
     * public void setSymptom(String symptom) { this.symptom = symptom; }
     */

    public double getWeight() {
        return weight;
    }

    public ArrayList<Medication> getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication.add(medication);
    }

    public void setDiagnoses(Diagnoses diagnoses) {
        this.diagnoses.add(diagnoses);
    }

    public ArrayList<String> getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        // for (String s : symptom){
        this.symptom.add(symptom);
    }

    public ArrayList<Diagnoses> getDiagnoses() {
        return diagnoses;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getSsn() {
        return ssn;
    }

    public char getGender() {
        return gender;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * This is the Overide toString to make sure the Name is being printed
     * Instead of an un-resolved format in this program
     */

    @Override
    public String toString() {
        // return String.format(lastName, firstName); // this is supposed to
        // print
        // last name first, then
        // first name
        return this.firstName + "," + this.lastName;

    }

} // end of Patient class
