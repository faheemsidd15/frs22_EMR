package edu.pitt.emr;

import javax.swing.JOptionPane;

/**
 * 
 * @author faheemsiddiqui This is the main class to run the program
 * 
 */

public class copyOfEMR {

    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {

        final String SENTINAL = "done"; // Got this from Homework solution 6

        Patient patient = new Patient("Brad", "Pitt", "123-45-6789", 'M', 165,
                67);
        Doctor doctor = new Doctor("Angelina", "Jolie", "987-65-4321",
                "Family Doctor");
        String symptom;
        do {
            symptom = JOptionPane
                    .showInputDialog("Please enter your symptom :\n Type 'Done' when finished.");

            patient.setSymptom(symptom);
        } // end of do

        while (!symptom.equalsIgnoreCase(SENTINAL));

        // end of while

        if (doctor.prescribe(patient) == true) {

            patient.getProfile();

        } // end of if doctor prescibe
        else {
            JOptionPane.showMessageDialog(null, "We cannot help you!");
        }
    }
} // end of EMR class
