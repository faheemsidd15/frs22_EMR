package edu.pitt.emr;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JTextArea;

//import edu.pitt.emr.Patient;

public class EMR {

    /**
     * Faheem Siddiqui
     * 
     * This is the Main Class for the EMR GUI Got much help from TA and from
     * other Class Mates
     * 
     * When Symptom Entered, There is a pop window displaying Info
     * 
     * The Program adds a Semi-colon every-time something is edited
     * 
     * It would not let me update Java Docs saying the
     * "The Javadoc command does not exist."
     * 
     * Created Javadocs from another computer
     * 
     */

    /* Global variables representing SWING controls for the parent frame */
    private JFrame EMR;

    private JLabel lblSelectPatient;
    private JLabel lblSymptoms;
    private JLabel lblEnterSymptoms;
    private JLabel lblPatientProfile;

    private JTextField txtTextBoxSymptoms;
    private JTextField txtTextBoxEnterSymptoms;
    private JTextArea txtTextAreaPatientProfile;

    private JComboBox cboComboBoxExample;

    private JFrame EditPatient;

    private JButton btnButtonExampleEdit;
    private JButton btnButtonSaveAllPatientTopFile;

    /* Global variables representing SWING controls for the child (popup) frame */
    private JFrame childFrame;
    private JButton btnButtonExample1;
    private JLabel lblPatientFirstName;
    private JLabel lblPatientLastName;
    private JLabel lblPatientAddress;
    private JLabel lblPatientCity;
    private JLabel lblPatientState;
    private JLabel lblPatientZip;
    private JLabel lblPatientSSN;
    private JLabel lblPatientHeight;
    private JLabel lblPatientWeight;
    private JLabel lblPatientGender;
    private JLabel lblPatientSymptomsList;

    private JButton btnPatientEditSave;
    private JButton btnPatientEditCancel;

    private JTextField txtTextBoxFirstName;
    private JTextField txtTextBoxLastName;
    private JTextField txtTextBoxAddress;
    private JTextField txtTextBoxCity;
    private JTextField txtTextBoxState;
    private JTextField txtTextBoxZip;
    private JTextField txtTextBoxSSN;
    private JTextField txtTextBoxEnterHeight;
    private JTextField txtTextBoxPatientWeight;
    private JTextField txtTextBoxGender;
    private JTextField txtTextBoxOfSymptoms;

    private Doctor d;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EMR window = new EMR();
        window.EMR.setVisible(true);
    }

    /**
     * Create the application.
     */
    public EMR() {
        d = new Doctor("Angelina", "Jolie", "696-69-1234", 'F');
        initEMR();
        initEditPatientInfomation();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initEMR() {
        EMR = new JFrame("EMR");
        EMR.setBounds(100, 100, 700, 600);
        EMR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EMR.getContentPane().setLayout(null);

        lblSelectPatient = new JLabel("Select Patient:");
        lblSelectPatient.setBounds(19, 42, 113, 16); // adjust size for Selct
                                                     // Patient button
        EMR.getContentPane().add(lblSelectPatient);

        cboComboBoxExample = new JComboBox();
        cboComboBoxExample.setBounds(
                lblSelectPatient.getX() + lblSelectPatient.getWidth() + 10,
                lblSelectPatient.getY(), 250, 30);
        for (Patient patient : d.getPatientList()) {
            cboComboBoxExample.addItem(patient);

        }

        EMR.getContentPane().add(cboComboBoxExample);
        cboComboBoxExample.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Patient p = (Patient) cboComboBoxExample.getSelectedItem();
                System.out.println(p + " = Selected");

                txtTextBoxSymptoms.setText(p.getSymptom().toString());

            }
        });
        // Edit Button

        btnButtonExampleEdit = new JButton("Edit");
        btnButtonExampleEdit.setBounds(cboComboBoxExample.getX()
                + cboComboBoxExample.getWidth() + 10,
                cboComboBoxExample.getY(), 70, 30);
        EMR.getContentPane().add(btnButtonExampleEdit);
        btnButtonExampleEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
                EditPatient.setVisible(true);
                Patient p = (Patient) cboComboBoxExample.getSelectedItem();
                txtTextBoxFirstName.setText(p.getFirstName());
                txtTextBoxLastName.setText(p.getLastName());
                txtTextBoxAddress.setText(p.getStreetAddress());
                txtTextBoxCity.setText(p.getCity());
                txtTextBoxState.setText(p.getState());
                txtTextBoxZip.setText(p.getZip());
                txtTextBoxSSN.setText(p.getSsn());
                // Add proper types to the attributes
                txtTextBoxEnterHeight.setText(Double.toString(p.getHeight()));
                txtTextBoxPatientWeight.setText(Double.toString(p.getWeight()));
                txtTextBoxGender.setText(Character.toString(p.getGender()));
                txtTextBoxOfSymptoms.setText(p.getSymptom().toString());
            }
        });

        lblSymptoms = new JLabel("Symptoms:");
        lblSymptoms.setBounds(20,
                lblSelectPatient.getY() + lblSelectPatient.getHeight() + 10,
                200, 20);
        EMR.getContentPane().add(lblSymptoms);

        txtTextBoxSymptoms = new JTextField();
        txtTextBoxSymptoms
                .setBounds(cboComboBoxExample.getX(), cboComboBoxExample.getY()
                        + cboComboBoxExample.getHeight() + 10, 310, 100);
        EMR.getContentPane().add(txtTextBoxSymptoms);

        lblEnterSymptoms = new JLabel("Enter Symptoms:");
        lblEnterSymptoms.setBounds(20, txtTextBoxSymptoms.getY()
                + txtTextBoxSymptoms.getHeight() + 15, 200, 20);
        EMR.getContentPane().add(lblEnterSymptoms);

        txtTextBoxEnterSymptoms = new JTextField();
        txtTextBoxEnterSymptoms
                .setBounds(txtTextBoxSymptoms.getX(), txtTextBoxSymptoms.getY()
                        + txtTextBoxSymptoms.getHeight() + 15, 310, 25);
        EMR.getContentPane().add(txtTextBoxEnterSymptoms);

        btnPatientEditSave = new JButton("Diagnose and Prescribe");
        btnPatientEditSave.setBounds(
                txtTextBoxSymptoms.getX() + 115,
                txtTextBoxEnterSymptoms.getY()
                        + txtTextBoxEnterSymptoms.getHeight() + 10, 200, 30);
        EMR.getContentPane().add(btnPatientEditSave);
        btnPatientEditSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Patient p = (Patient) cboComboBoxExample.getSelectedItem();
                p.setSymptom(txtTextBoxEnterSymptoms.getText());

                d.prescribe(p);
                txtTextAreaPatientProfile.setText(p.getProfile());
            }
        });
        lblPatientProfile = new JLabel("Patient Profile:");
        lblPatientProfile.setBounds(20, btnPatientEditSave.getY()
                + btnPatientEditSave.getHeight() + 15, 125, 20);
        EMR.getContentPane().add(lblPatientProfile);

        txtTextAreaPatientProfile = new JTextArea();
        txtTextAreaPatientProfile
                .setBounds(txtTextBoxSymptoms.getX(), btnPatientEditSave.getY()
                        + btnPatientEditSave.getHeight() + 15, 310, 200);
        EMR.getContentPane().add(txtTextAreaPatientProfile);

        btnButtonSaveAllPatientTopFile = new JButton("Save All Patient to File");
        btnButtonSaveAllPatientTopFile.setBounds(
                btnPatientEditSave.getX(),
                txtTextAreaPatientProfile.getY()
                        + txtTextAreaPatientProfile.getHeight() + 10, 200, 30);
        EMR.getContentPane().add(btnButtonSaveAllPatientTopFile);
        btnButtonSaveAllPatientTopFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * For the Writer, I have the method in Doctor class too But not
                 * sure that is whats writing to file
                 */
                d.savePatientData(); // This method is working

                /**
                 * Adds a semi-colon when writing to file
                 */

                /*
                 * String print = ""; try { BufferedWriter bW = new
                 * BufferedWriter(new FileWriter( "data/patient_list.txt")); for
                 * (Patient p : d.getPatientList()) { print = p.getLastName() +
                 * ","; print += p.getFirstName() + ","; print +=
                 * p.getStreetAddress() + ","; print += p.getCity() + ","; print
                 * += p.getState() + ","; print += p.getZip() + ","; print +=
                 * p.getSsn() + ","; print += p.getGender() + ","; print +=
                 * p.getWeight() + ","; print += p.getHeight() + ",";
                 * 
                 * // symptoms String symptomList = ""; for (String s :
                 * p.getSymptom()) { symptomList += s + ";"; } print +=
                 * symptomList; // write output to file bW.write(print + "\n");
                 * } bW.close(); } catch (IOException ex) {
                 * ex.printStackTrace(); }
                 */
            }
        });

    }

    private void initEditPatientInfomation() {
        EditPatient = new JFrame("Edit Patient");
        EditPatient.setBounds(100, 100, 580, 600);
        EditPatient.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        EditPatient.getContentPane().setLayout(null);
        EditPatient.setVisible(false);

        lblPatientFirstName = new JLabel("First Name:");
        lblPatientFirstName.setBounds(20, 0, 125, 20);
        EditPatient.getContentPane().add(lblPatientFirstName);

        txtTextBoxFirstName = new JTextField();
        txtTextBoxFirstName.setBounds(lblPatientFirstName.getX()
                + lblPatientFirstName.getWidth() + 10,
                lblPatientFirstName.getY(), 290, 30);
        EditPatient.getContentPane().add(txtTextBoxFirstName);

        lblPatientLastName = new JLabel("Last Name:");
        lblPatientLastName.setBounds(20, lblPatientFirstName.getY()
                + lblPatientFirstName.getHeight() + 10, 125, 20);
        EditPatient.getContentPane().add(lblPatientLastName);

        txtTextBoxLastName = new JTextField();
        txtTextBoxLastName.setBounds(lblPatientLastName.getX()
                + lblPatientLastName.getWidth() + 10,
                lblPatientLastName.getY(), 290, 30);
        EditPatient.getContentPane().add(txtTextBoxLastName);

        lblPatientAddress = new JLabel("Address:");
        lblPatientAddress.setBounds(20, lblPatientLastName.getY()
                + lblPatientLastName.getHeight() + 10, 125, 20);
        EditPatient.getContentPane().add(lblPatientAddress);

        txtTextBoxAddress = new JTextField();
        txtTextBoxAddress.setBounds(lblPatientAddress.getX()
                + lblPatientAddress.getWidth() + 10, lblPatientAddress.getY(),
                290, 30);
        EditPatient.getContentPane().add(txtTextBoxAddress);

        lblPatientCity = new JLabel("City:");
        lblPatientCity.setBounds(20, 115, 125, 20);
        EditPatient.getContentPane().add(lblPatientCity);

        txtTextBoxCity = new JTextField();
        txtTextBoxCity.setBounds(
                lblPatientCity.getX() + lblPatientCity.getWidth() + 10,
                lblPatientCity.getY(), 290, 30);
        EditPatient.getContentPane().add(txtTextBoxCity);

        lblPatientState = new JLabel("State:");
        lblPatientState.setBounds(20, 145, 125, 20);
        EditPatient.getContentPane().add(lblPatientState);

        txtTextBoxState = new JTextField();
        txtTextBoxState.setBounds(
                lblPatientState.getX() + lblPatientState.getWidth() + 10,
                lblPatientState.getY(), 75, 30);
        EditPatient.getContentPane().add(txtTextBoxState);

        lblPatientZip = new JLabel("Zip:");
        lblPatientZip.setBounds(
                txtTextBoxState.getX() + txtTextBoxState.getWidth() + 10,
                txtTextBoxState.getY(), 50, 30);
        EditPatient.getContentPane().add(lblPatientZip);

        txtTextBoxZip = new JTextField();
        txtTextBoxZip.setBounds(lblPatientZip.getX() + lblPatientZip.getWidth()
                + 10, lblPatientZip.getY(), 125, 30);
        EditPatient.getContentPane().add(txtTextBoxZip);

        lblPatientSSN = new JLabel("SSN:");
        lblPatientSSN.setBounds(20, 180, 125, 20);
        EditPatient.getContentPane().add(lblPatientSSN);

        txtTextBoxSSN = new JTextField();
        txtTextBoxSSN.setBounds(lblPatientSSN.getX() + lblPatientSSN.getWidth()
                + 10, lblPatientSSN.getY(), 290, 30);
        EditPatient.getContentPane().add(txtTextBoxSSN);

        lblPatientHeight = new JLabel("Height:");
        lblPatientHeight.setBounds(20, 234, 125, 20);
        EditPatient.getContentPane().add(lblPatientHeight);

        txtTextBoxEnterHeight = new JTextField();
        txtTextBoxEnterHeight.setBounds(155, 229, 59, 30);
        EditPatient.getContentPane().add(txtTextBoxEnterHeight);

        lblPatientWeight = new JLabel("Weight:");
        lblPatientWeight.setBounds(215, 229, 68, 30);
        EditPatient.getContentPane().add(lblPatientWeight);

        txtTextBoxPatientWeight = new JTextField();
        txtTextBoxPatientWeight.setBounds(285, 229, 50, 30);
        EditPatient.getContentPane().add(txtTextBoxPatientWeight);

        lblPatientGender = new JLabel("Gender:");
        lblPatientGender.setBounds(336, 229, 75, 30);
        EditPatient.getContentPane().add(lblPatientGender);

        txtTextBoxGender = new JTextField();
        txtTextBoxGender.setBounds(426, 229, 75, 30);
        EditPatient.getContentPane().add(txtTextBoxGender);

        lblPatientSymptomsList = new JLabel("Symptoms:");
        lblPatientSymptomsList.setBounds(20, 270, 125, 20);
        EditPatient.getContentPane().add(lblPatientSymptomsList);

        txtTextBoxOfSymptoms = new JTextField();
        txtTextBoxOfSymptoms.setBounds(41, 306, 460, 100);
        EditPatient.getContentPane().add(txtTextBoxOfSymptoms);

        btnPatientEditSave = new JButton("Save Patient");
        btnPatientEditSave.setBounds(215, 434, 135, 20);
        EditPatient.getContentPane().add(btnPatientEditSave);
        btnPatientEditSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Patient p = (Patient) cboComboBoxExample.getSelectedItem();
                p.setFirstName(txtTextBoxFirstName.getText());
                p.setLastName(txtTextBoxLastName.getText());
                p.setStreetAddress(txtTextBoxAddress.getText());
                p.setCity(txtTextBoxCity.getText());
                p.setState(txtTextBoxState.getText());
                p.setZip(txtTextBoxZip.getText());
                p.setSsn(txtTextBoxSSN.getText());
                p.setHeight(Double.parseDouble(txtTextBoxEnterHeight.getText()));
                p.setWeight(Double.parseDouble(txtTextBoxPatientWeight
                        .getText()));
                p.setGender(txtTextBoxGender.getText().charAt(0));

            }

        });
        btnPatientEditCancel = new JButton("Cancel");
        btnPatientEditCancel.setBounds(381, 434, 138, 20);
        EditPatient.getContentPane().add(btnPatientEditCancel);
        btnPatientEditCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Canceled");
                EditPatient.setVisible(false);
            }
        });

    }
}

/*
 * private void initChildFrame() { childFrame = new JFrame("CHILD FRAME");
 * childFrame.setBounds(100, 100, 400, 200);
 * childFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 * childFrame.getContentPane().setLayout(null); childFrame.setVisible(false);
 * 
 * btnButtonExample1 = new JButton("Hide This Window");
 * btnButtonExample1.setBounds(10, 10, 200, 30);
 * btnButtonExample1.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { childFrame.setVisible(false); } });
 * childFrame.getContentPane().add(btnButtonExample1);
 * 
 * }
 */

