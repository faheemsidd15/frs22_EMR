package edu.pitt.emr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class EMR1 {

    /**
     * This class was not used Designed Through Window Builder
     */

    private JFrame EMR;
    private JTextField textField;
    private JLabel lblSelectPatient;
    private JList list;
    private JComboBox comboBoxNameOFP;
    private JButton btnEdit;
    private JLabel lblSym;
    private JTextArea textArea;
    private JLabel lblEnterSymptom;
    private JButton btnDiagnoseAndPrescribe;
    private JLabel lblPatientProfile;
    private JTextArea textArea_1;
    private JButton btnNewButton;
    private Doctor d;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    EMR1 window = new EMR1();
                    window.EMR.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public EMR1() {
        initialize();
        d = new Doctor("Angelina", "Jolie", "696-69-1234", 'F');
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        EMR = new JFrame();
        EMR.setTitle("EMR");
        EMR.setBounds(100, 100, 500, 578);
        EMR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EMR.getContentPane().setLayout(null);

        lblSelectPatient = new JLabel("Select Patient:"); // Select patient
                                                          // attribute
        lblSelectPatient.setBounds(19, 42, 113, 16);
        EMR.getContentPane().add(lblSelectPatient);

        list = new JList(); // Select Patient attribute
        list.setBounds(148, 135, 1, 1);
        EMR.getContentPane().add(list);

        comboBoxNameOFP = new JComboBox(); // Select Patient attribute
        comboBoxNameOFP.setBounds(141, 29, 242, 29);
        EMR.getContentPane().add(comboBoxNameOFP);
        for (Patient patient : d.getPatientList()) {
            comboBoxNameOFP.addItem(patient);
        }

        btnEdit = new JButton("Edit"); // Edit this needs to do pop up window
        btnEdit.setBounds(381, 35, 117, 29);
        EMR.getContentPane().add(btnEdit);

        lblSym = new JLabel("Symptoms:");
        lblSym.setBounds(19, 135, 75, 16);
        EMR.getContentPane().add(lblSym);

        textArea = new JTextArea();
        textArea.setBounds(106, 135, 359, 57);
        EMR.getContentPane().add(textArea);

        lblEnterSymptom = new JLabel("Enter Symptom:");
        lblEnterSymptom.setBounds(19, 239, 104, 16);
        EMR.getContentPane().add(lblEnterSymptom);

        textField = new JTextField();
        textField.setBounds(125, 233, 295, 28);
        EMR.getContentPane().add(textField);
        textField.setColumns(10);

        btnDiagnoseAndPrescribe = new JButton("Diagnose and Prescribe");
        btnDiagnoseAndPrescribe.setBounds(197, 292, 223, 29);
        EMR.getContentPane().add(btnDiagnoseAndPrescribe);

        lblPatientProfile = new JLabel("Patient Profile:");
        lblPatientProfile.setBounds(17, 334, 106, 16);
        EMR.getContentPane().add(lblPatientProfile);

        textArea_1 = new JTextArea();
        textArea_1.setBounds(27, 362, 438, 71);
        EMR.getContentPane().add(textArea_1);

        btnNewButton = new JButton("Save All Patients to File");
        btnNewButton.setBounds(231, 459, 203, 29);
        EMR.getContentPane().add(btnNewButton);

    }
}
