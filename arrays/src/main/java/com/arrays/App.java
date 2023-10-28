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
        // setframe background
        frame.getContentPane().setBackground(Color.GRAY);

        // / create first panel
        JPanel panel1 = new JPanel();

        // set border green
        panel1.setPreferredSize(new Dimension(500, 200));
        // set panel 1 as grid of 3 collumnts and 3 row
        GridLayout gridLayout = new GridLayout(5, 2);
        // set horizontal gab
        gridLayout.setHgap(10);
        // set vertical gap
        gridLayout.setVgap(10);
        // set layout as grid
        panel1.setLayout(gridLayout);

        JPanel titePanel = new JPanel();
        // set background
        titePanel.setBackground(Color.BLACK);
        // set size
        titePanel.setPreferredSize(new Dimension(500, 50));
        // set font color
        titePanel.setForeground(Color.WHITE);
        // set font size
        titePanel.setFont(new Font("Arial", Font.PLAIN, 30));
        // set text
        JLabel titleLabel = new JLabel("Add New Company Data");
        // set font size
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        // set font color
        titleLabel.setForeground(Color.WHITE);
        // align font center
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // add text to panel
        titePanel.add(titleLabel);

        final JLabel companyNameLabel = new JLabel("Company Name");
        final JTextField companyNameField = new JTextField(40);

        final JLabel dateOfRegistrationLabel = new JLabel("Date of Registration");
        final JTextField dateOfRegistrationField = new JTextField(40);

        final JLabel numberOfEmployeesLabel = new JLabel("Number of Employees");
        final JTextField numberOfEmployeesField = new JTextField(40);

        final JLabel isItCharitableLabel = new JLabel("Is it Charitable");
        final JCheckBox isItCharitableCheckBox = new JCheckBox();
        // scasle up checkbox
        isItCharitableCheckBox.setSize(50, 50);
        // set to unchecked
        isItCharitableCheckBox.setSelected(false);

        // when submit is clicked show the data in a new window
        final JLabel submitLabel = new JLabel("Add Company");
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 100, 50, 20);

        // set font size
        companyNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfRegistrationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        numberOfEmployeesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        isItCharitableLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        submitLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // set font size
        companyNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfRegistrationField.setFont(new Font("Arial", Font.PLAIN, 20));
        numberOfEmployeesField.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));

        // set all labels to have the same size
        companyNameLabel.setPreferredSize(new Dimension(70, 10));
        dateOfRegistrationLabel.setPreferredSize(new Dimension(70, 10));
        numberOfEmployeesLabel.setPreferredSize(new Dimension(70, 10));
        isItCharitableLabel.setPreferredSize(new Dimension(70, 10));
        submitLabel.setPreferredSize(new Dimension(70, 10));

        // set all fields to have the same size
        companyNameField.setPreferredSize(new Dimension(150, 10));
        dateOfRegistrationField.setPreferredSize(new Dimension(150, 10));
        numberOfEmployeesField.setPreferredSize(new Dimension(150, 10));
        isItCharitableCheckBox.setPreferredSize(new Dimension(150, 10));
        submitButton.setPreferredSize(new Dimension(150, 10));
        submitButton.setBounds(400, 400, 150, 15);

        // set all labes to be on the left side of the layout
        companyNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateOfRegistrationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        numberOfEmployeesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        isItCharitableLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // set all fields to be on the same side of the gridlayout
        companyNameField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dateOfRegistrationField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        numberOfEmployeesField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        isItCharitableCheckBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        submitButton.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // add the fields to the panel to the right and labels to the left
        panel1.add(companyNameLabel);
        panel1.add(companyNameField);
        panel1.add(dateOfRegistrationLabel);
        panel1.add(dateOfRegistrationField);
        panel1.add(numberOfEmployeesLabel);
        panel1.add(numberOfEmployeesField);
        panel1.add(isItCharitableLabel);
        panel1.add(isItCharitableCheckBox);
        panel1.add(submitLabel);
        panel1.add(submitButton);

        // create second panel
        JPanel panel2 = new JPanel();
        // set border red
        panel2.setBorder(BorderFactory.createLineBorder(Color.RED));
        // set background
        panel2.setBackground(Color.GRAY);
        // set size
        panel2.setPreferredSize(new Dimension(550, 300));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBorder(BorderFactory.createRaisedBevelBorder());
        // set round border
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        // add ttile to panel 2
        JLabel titleLabel2 = new JLabel("List of Companies");
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        // set height
        titleLabel2.setPreferredSize(new Dimension(550, 50));
        // set empty bnordr
        titleLabel2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        // add title to panel 2
        // set background to light gray
        titleLabel2.setBackground(Color.LIGHT_GRAY);
        // center text
        titleLabel2.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(titleLabel2);

        // add text area to panel 2
        final JTextArea textArea = new JTextArea(20, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // make it not editable
        textArea.setEditable(false);
        // set font size
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));

        // add scroll bar
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        // add the scroll pane to the panel
        panel2.add(scrollPane);

        // add textarea to scollpane
        scrollPane.setViewportView(textArea);

        // fix size of pannel 2
        panel2.setMinimumSize(new Dimension(400, 100));
        panel2.setMaximumSize(new Dimension(550, 400));

        // set max size of panel 1
        panel1.setMaximumSize(new Dimension(550, 200));

        // set max for title panel
        titePanel.setMaximumSize(new Dimension(550, 50));

        // close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        closeButton.setPreferredSize(new Dimension(100, 20));
        closeButton.setBounds(400, 400, 150, 15);
        // alight left
        closeButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        // add close button to panel 2
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 20));
        // add evvent listner for close button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close the frame
                frame.dispose();
            }
        });

        panel2.add(closeButton);

        // create a container panel to hold the two panels
        final JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(titePanel, containerPanel, 0);
        containerPanel.add(panel1);
        containerPanel.add(panel2);

        // set frame size
        frame.setSize(650, 650);

        // add the container panel to the frame
        frame.add(containerPanel);

        frame.pack();
        frame.setVisible(true);

        // set frame close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    br.write("\n----------------------------------------------------------------------------\n");

                    br.close();
                    fr.close();
                } catch (IOException e1) {
                    System.out.println("Error writing to file");
                }

                // add text to panel 2
                textArea.append("Company Name: " + companyName + "\t");
                textArea.append("Date of Registration: " + dateOfRegistration + "\t\n");
                textArea.append("Number of Employees: " + numberOfEmployees + "\t");
                textArea.append("Is it Charitable: " + isItCharitable + "\t");
                textArea.append("\n----------------------------------------------------------------------------\n");
            }
        });

    }
}