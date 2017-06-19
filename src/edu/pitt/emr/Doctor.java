package edu.pitt.emr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;

public class Doctor extends User {

    /**
     * This class is for the classifications of a Doctor
     * 
     * 
     */

    private String specialization;
    private ArrayList<String> symptomList = new ArrayList<String>();

    private ArrayList<String> diagnList = new ArrayList<String>();

    private ArrayList<String> medList = new ArrayList<String>();

    private ArrayList<Patient> patientList = new ArrayList<Patient>();

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     * @param gender
     */
    public Doctor(String firstName, String lastName, String ssn, char gender) {
        super(firstName, lastName, ssn, gender);
        /*
         * this.firstName = firstName; this.lastName = lastName; this.ssn = ssn
         */;

        loadDiagnosticData();
        loadPatientData();
        savePatientData();

        /*
         * // Took this from HW solutions Build employeeID. Replace dashes with
         * // empty strings (strip dashes) this.employeeID = ssn.replace("-",
         * ""); // Strip spaces this.employeeID = this.employeeID.replace(" ",
         * ""); // Concatenate first letter of the first and last name to
         * patientID this.employeeID = this.employeeID +
         * this.firstName.substring(0, 1) + this.lastName.substring(0, 1);
         */

    } // end of Doctor First Name, Last name , ssn, and specialization

    /**
     * This is to load the Diagnostic data Learned From youtube vids
     * 
     */

    public void loadDiagnosticData() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("data/diagnostic_data.txt");
            br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] diagList = line.split(",");

                symptomList.add(diagList[0]);
                diagnList.add(diagList[1]);
                medList.add(diagList[2]);

                /*
                 * String symptom = new String(diagList[0]);
                 * 
                 * Diagnoses diag = new Diagnoses(0, diagList[1]);
                 * 
                 * Medication meds = new Medication(0, diagList[2]);
                 */

                // System.out.println(symptomList);
                // System.out.println(line);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {

            // e.printStackTrace();
            System.out.println("Unable to find data file");
        } catch (IOException e) {

            // e.printStackTrace();
            System.out.println("Unable to acces data file");
        }

    } // end of load diagnostic data

    /**
     * This Method is to load the Patent Data Learned From your YOUtube vids
     * 
     */

    private void loadPatientData() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("data/patient_list.txt");
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] patientList = line.split(",");
                //String[] symList = patientList[10].split(";");
                if (patientList.length == 11) {
                    Patient patient = new Patient(patientList[1],
                            patientList[0], patientList[6],
                            patientList[7].charAt(0),
                            Double.parseDouble(patientList[8]),
                            Double.parseDouble(patientList[9]));

                    for (int i = 10; i < patientList.length; i++) {
                        patient.setSymptom(patientList[i]);
                    }
                    patient.setStreetAddress(patientList[2]);
                    patient.setCity(patientList[3]);
                    patient.setState(patientList[4]);
                    patient.setZip(patientList[5]);
                    this.patientList.add(patient);

                    /*
                     * for (String s : symList) { patient.setSymptom(s);
                     * 
                     * for (String x : patient.getSymptom()) {
                     * System.out.println(symList); }
                     * 
                     * }
                     */// for loop
                }

                // System.out.println(line);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {

            // e.printStackTrace();
            System.out.println("Unable to find data file");
        } catch (IOException e) {

            // e.printStackTrace();
            System.out.println("Unable to acces data file");
        }

    } // end of load patient data

    /**
     * This is to save the Patient File Updated classmate helped with this But
     * some reason will not work on The EMR while loading the method
     * 
     */
    public void savePatientData() {
        String print = "";
        try {
            BufferedWriter bW = new BufferedWriter(new FileWriter(
                    "data/patient_list.txt"));
            for (Patient p : this.getPatientList()) {
                print = p.getLastName() + ",";
                print += p.getFirstName() + ",";
                print += p.getStreetAddress() + ",";
                print += p.getCity() + ",";
                print += p.getState() + ",";
                print += p.getZip() + ",";
                print += p.getSsn() + ",";
                print += p.getGender() + ",";
                print += p.getWeight() + ",";
                print += p.getHeight() + ",";

                String symptomList = "";
                for (String s : p.getSymptom()) {
                    symptomList += s + ";";

                }
                print += symptomList;

                bW.write(print + "\n");
                // System.out.println(p.getLastName());
            }
            bW.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    } // End of Save Patient Data

    /**
     * The Prescribe method has changed to boolean
     * 
     * Changed to array
     * 
     * Commented out all the boolean logic Kept it just in case
     * 
     * @param patient
     * @return
     */
    public void prescribe(Patient patient) { // Took this from HW solutions
                                             // 4, but changed to boolean
        // Changed to public void method after the boolean

        /*
         * String[] symptomList = { "Headache", "Cough", "Fever", "Stomachache"
         * }; String[] diagnosesList = { "Dehidration", "Common cold",
         * "Influenza", "Food poisoning" }; String[] medList = { "Tylenol",
         * "Cough drops", "Tamiflu", "Pepto-Bismol" };
         */

        // boolean whatever = false; // got help with class mate with this
        // boolean yoMama;

        for (String good : patient.getSymptom()) {

            // yoMama = false;

            for (int i = 0; i < symptomList.size(); i++) {

                if (good.equalsIgnoreCase(symptomList.get(i))) {
                    // whatever = true;
                    // yoMama = true;
                    Medication medication = new Medication(i, medList.get(i));
                    Diagnoses diagnoses = new Diagnoses(i, diagnList.get(i));
                    patient.setDiagnoses(diagnoses);
                    patient.setMedication(medication);

                }

            } // end of enhanced for loop for patient.getSymptom()
            /*
             * if (good.equalsIgnoreCase("done")) { return whatever; }
             * 
             * if (!yoMama) { Medication medication = new Medication(0, null);
             * Diagnoses diagnoses = new Diagnoses(0, null);
             * patient.setDiagnoses(diagnoses);
             * patient.setMedication(medication);
             * 
             * }
             */

            // yoMama = false;

        }
        // return whatever;

        /*
         * String symptom = patient.getSymptom(); Medication medication;
         * Diagnoses diagnoses; if (symptom.equalsIgnoreCase("headache")) {
         * medication = new Medication(1, "Tylenol"); diagnoses = new
         * Diagnoses(1, "Dehydration"); patient.setDiagnoses(diagnoses);
         * 
         * } else if (symptom.equalsIgnoreCase("cough")) { medication = new
         * Medication(2, "Cough Drops"); diagnoses = new Diagnoses(2,
         * "Common Cold");
         * 
         * } else if (symptom.equalsIgnoreCase("fever")) { medication = new
         * Medication(3, "Tamiflu"); diagnoses = new Diagnoses(3, "Influenza");
         * 
         * } else { medication = null; diagnoses = null;
         * JOptionPane.showMessageDialog(null,
         * "We cannot figure out your diagnosis"); return false; }
         * patient.setDiagnoses(diagnoses); patient.setMedication(medication);
         * return true;
         */

    } // *******************end of prescribe****************************

    /*
     * public void savePatientData() { try { FileWriter fw = new
     * FileWriter("data/patient_list.txt"); BufferedWriter bw = new
     * BufferedWriter(fw); for (String line : lines) { bw.write(line);
     * bw.newLine(); } bw.close(); fw.close(); } catch (IOException e) {
     * System.out.println(e.getMessage()); }
     * 
     * } // end of Save Patient Data
     */

    /**
     * More Getters and Setters
     * 
     * @return
     */
    public ArrayList<String> getDiagnList() {
        return diagnList;
    }

    public void setDiagnList(ArrayList<String> diagnList) {
        this.diagnList = diagnList;
    }

    public ArrayList<String> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(ArrayList<String> symptomList) {
        this.symptomList = symptomList;
    }

    public ArrayList<String> getMedList() {
        return medList;
    }

    public void setMedList(ArrayList<String> medList) {
        this.medList = medList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    /*
     * public void setEmployeeID(String employeeID) { this.employeeID =
     * employeeID; }
     */

    /**
     * Getters and setters for the Doctor Class
     */

    /*
     * public String getFirstName() { return firstName; }
     * 
     * public void setFirstName(String firstName) { this.firstName = firstName;
     * }
     * 
     * public String getLastName() { return lastName; }
     * 
     * public void setLastName(String lastName) { this.lastName = lastName; }
     */

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /*
     * public String getEmployeeID() { return employeeID; }
     * 
     * public String getSsn() { return ssn; }
     */

}// end of Doctor class
