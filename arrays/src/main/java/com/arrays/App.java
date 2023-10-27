package com.arrays;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;

public class App {

    public static void main(String[] args) {
        // create a new JFrame
        final JFrame frame = new JFrame("Company Data Logger");

        // create a new JPanel
        final JPanel panel = new JPanel();

        // create comany name field
        final JLabel companyNameLabel = new JLabel("Company Name:");
        final JTextField companyNameField = new JTextField(20);

        // date of registration field
        final JLabel dateOfRegistrationLabel = new JLabel("Date of Registration:");
        final JTextField dateOfRegistrationField = new JTextField(20);

        // number of empleyees
        final JLabel numberOfEmployeesLabel = new JLabel("Number of Employees:");
        final JTextField numberOfEmployeesField = new JTextField(20);

        // is it charitable checkbox
        final JLabel isItCharitableLabel = new JLabel("Is it Charitable:");
        final JCheckBox isItCharitableCheckBox = new JCheckBox();

        // submit button
        final JButton submitButton = new JButton("Submit");

        // SET ALL LABELS TO BOLD AND HAVE THE SAME WITH
        companyNameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        dateOfRegistrationLabel.setFont(new Font("Serif", Font.BOLD, 20));
        numberOfEmployeesLabel.setFont(new Font("Serif", Font.BOLD, 20));
        isItCharitableLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // SET ALL FIELDS TO HAVE THE SAME FONT
        companyNameField.setFont(new Font("Serif", Font.BOLD, 20));
        dateOfRegistrationField.setFont(new Font("Serif", Font.BOLD, 20));
        numberOfEmployeesField.setFont(new Font("Serif", Font.BOLD, 20));

        // SET THE CHECKBOX TO BE UNSELECTED BY DEFAULT
        isItCharitableCheckBox.setSelected(false);

        // LEFT ALIGN ALL LABELS
        companyNameLabel.setHorizontalAlignment(JLabel.LEFT);
        dateOfRegistrationLabel.setHorizontalAlignment(JLabel.LEFT);
        numberOfEmployeesLabel.setHorizontalAlignment(JLabel.LEFT);
        isItCharitableLabel.setHorizontalAlignment(JLabel.LEFT);

        // RIUGHT ALIGN ALL FIELDS
        companyNameField.setHorizontalAlignment(JTextField.RIGHT);
        dateOfRegistrationField.setHorizontalAlignment(JTextField.RIGHT);
        numberOfEmployeesField.setHorizontalAlignment(JTextField.RIGHT);

        // add padding to fields
        companyNameField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dateOfRegistrationField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
                10));
        numberOfEmployeesField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
                10));
        isItCharitableCheckBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,
                20));

        // ADD BORDER TO FIELDS
        companyNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dateOfRegistrationField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        numberOfEmployeesField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        isItCharitableCheckBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // add some margin to the button
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // submit button font size
        submitButton.setFont(new Font("Serif", Font.BOLD, 20));
        // align button to centre
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add the label and the text field to the panel
        panel.add(companyNameLabel);
        panel.add(companyNameField);
        panel.add(dateOfRegistrationLabel);
        panel.add(dateOfRegistrationField);
        panel.add(numberOfEmployeesLabel);
        panel.add(numberOfEmployeesField);
        panel.add(isItCharitableLabel);
        panel.add(isItCharitableCheckBox);
        panel.add(submitButton);

        // set the size of the frame
        frame.setSize(400, 600);

        // add the panel to the frame
        frame.add(panel);

        // make the frame visible
        frame.setVisible(true);

        // set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // when submit is clicked show the data in a new window
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new JFrame
                JFrame frame = new JFrame("Company Data");

                // create a new JPanel
                JPanel panel = new JPanel();

                // get the input from the fields
                String companyName = companyNameField.getText();
                String dateOfRegistration = dateOfRegistrationField.getText();
                String numberOfEmployees = numberOfEmployeesField.getText();
                String isItCharitable = isItCharitableCheckBox.isSelected() ? "Yes" : "No";

                // write the data to file txt
                File file = new File("company.txt");
                FileWriter fr;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e1) {
                    System.out.println("Error writing to file");
                    return;
                }

                BufferedWriter br = new BufferedWriter(fr);

                try {
                    br.write("Company Name: " + companyName + "\n");
                    br.write("Date of Registration: " + dateOfRegistration + "\n");
                    br.write("Number of Employees: " + numberOfEmployees + "\n");
                    br.write("Is it Charitable: " + isItCharitable + "\n");
                    br.write("\n");

                    br.close();
                    fr.close();
                } catch (IOException e1) {
                    System.out.println("Error writing to file");
                }

            }
        });

    }
}