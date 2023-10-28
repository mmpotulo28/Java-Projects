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

        /***************** PANEL 1 ****************/
        // / create first panel
        final JPanel panel1 = new JPanel();
        // set border green
        panel1.setPreferredSize(new Dimension(500, 200));
        // set panel 1 as grid of 3 collumnts and 3 row
        GridLayout gridLayout = new GridLayout(7, 2);
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

        final JLabel categoryLabel = new JLabel("Category: ");
        final String[] categoryOptions = { "Choose Option", "For Profit", "Non Profit" }; // set options
        final JComboBox category = new JComboBox(categoryOptions); // create combobox for options
        // set default value
        category.setSelectedIndex(0);

        final JLabel companyNameLabel = new JLabel("Company Name");
        final JTextField companyNameField = new JTextField(40);

        final JLabel dateOfRegistrationLabel = new JLabel("Date of Registration");
        final JTextField dateOfRegistrationField = new JTextField(40);

        // no of employees for profit companies
        final JLabel numberOfEmployeesLabel = new JLabel("Number of Employees");
        final JTextField numberOfEmployeesField = new JTextField(40);

        // checkbox for non profit companies
        final JLabel isItCharitableLabel = new JLabel("Is it Charitable");
        final JCheckBox isItCharitableCheckBox = new JCheckBox();
        // scasle up checkbox
        isItCharitableCheckBox.setSize(50, 50);
        // set to unchecked
        isItCharitableCheckBox.setSelected(false);

        // submit button
        final JLabel submitLabel = new JLabel("Add Company");
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 100, 50, 20);

        // set font size
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        companyNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfRegistrationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        numberOfEmployeesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        isItCharitableLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        submitLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // set font size
        category.setFont(new Font("Arial", Font.PLAIN, 20));
        companyNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfRegistrationField.setFont(new Font("Arial", Font.PLAIN, 20));
        numberOfEmployeesField.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));

        // set all labels to have the same size
        categoryLabel.setPreferredSize(new Dimension(70, 10));
        companyNameLabel.setPreferredSize(new Dimension(70, 10));
        dateOfRegistrationLabel.setPreferredSize(new Dimension(70, 10));
        numberOfEmployeesLabel.setPreferredSize(new Dimension(70, 10));
        isItCharitableLabel.setPreferredSize(new Dimension(70, 10));
        submitLabel.setPreferredSize(new Dimension(70, 10));

        // set all fields to have the same size
        category.setPreferredSize(new Dimension(150, 50));
        companyNameField.setPreferredSize(new Dimension(150, 10));
        dateOfRegistrationField.setPreferredSize(new Dimension(150, 10));
        numberOfEmployeesField.setPreferredSize(new Dimension(150, 10));
        isItCharitableCheckBox.setPreferredSize(new Dimension(150, 10));
        submitButton.setPreferredSize(new Dimension(150, 10));
        submitButton.setBounds(400, 400, 150, 15);

        // set all labes to be on the left side of the layout
        categoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        companyNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateOfRegistrationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        numberOfEmployeesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        isItCharitableLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // set all fields to be on the same side of the gridlayout
        category.setAlignmentX(Component.RIGHT_ALIGNMENT);
        companyNameField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dateOfRegistrationField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        numberOfEmployeesField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        isItCharitableCheckBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        submitButton.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // allign the content inside the panel in the center
        panel1.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel1.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (category.getSelectedIndex() == 0) {
            submitButton.setEnabled(false);
            companyNameField.setEditable(false);
            dateOfRegistrationField.setEditable(false);
            numberOfEmployeesField.setEditable(false);
            isItCharitableCheckBox.setEnabled(false);
        } else {
            submitButton.setEnabled(true);
            companyNameField.setEditable(true);
            dateOfRegistrationField.setEditable(true);
            numberOfEmployeesField.setEditable(true);
            isItCharitableCheckBox.setEnabled(true);
        }

        // add action listern on fields
        companyNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if fields have values dont allow category to change
                if (companyNameField.getText().length() > 0 || dateOfRegistrationField.getText().length() > 0
                        || numberOfEmployeesField.getText().length() > 0) {
                    // displable choose category
                    category.setEnabled(false);
                } else {
                    // enable choose category
                    category.setEnabled(true);
                }
            }
        });

        // if the category is is on default value, disable the submit button and make
        // all other filed uneditable
        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if fields have values dont allow category to change
                if (companyNameField.getText().length() > 0 || dateOfRegistrationField.getText().length() > 0
                        || numberOfEmployeesField.getText().length() > 0) {

                    // show error message
                    JOptionPane.showMessageDialog(frame,
                            "Please submit the current company first before changing, or clear the fileds!");
                } else {

                    if (category.getSelectedIndex() == 0) {
                        submitButton.setEnabled(false);
                        companyNameField.setEditable(false);
                        dateOfRegistrationField.setEditable(false);
                        numberOfEmployeesField.setEditable(false);
                        isItCharitableCheckBox.setEnabled(false);
                    } else {
                        submitButton.setEnabled(true);
                        companyNameField.setEditable(true);
                        dateOfRegistrationField.setEditable(true);
                        numberOfEmployeesField.setEditable(true);
                        isItCharitableCheckBox.setEnabled(true);
                    }

                    // if company is for profit, add number of employees field before submit button
                    if (category.getSelectedIndex() == 1) {
                        // remove submit button and field
                        panel1.remove(submitLabel);
                        panel1.remove(submitButton);
                        // add the number of employees field
                        panel1.add(numberOfEmployeesLabel);
                        panel1.add(numberOfEmployeesField);
                        // add the submit button
                        panel1.add(submitLabel);
                        panel1.add(submitButton);
                        // remove the checkbox
                        panel1.remove(isItCharitableLabel);
                        panel1.remove(isItCharitableCheckBox);
                    } else if (category.getSelectedIndex() == 2) {
                        // remove submit button and field
                        panel1.remove(submitLabel);
                        panel1.remove(submitButton);
                        // add the checkbox
                        panel1.add(isItCharitableLabel);
                        panel1.add(isItCharitableCheckBox);
                        // add the submit button
                        panel1.add(submitLabel);
                        panel1.add(submitButton);
                        // remove the number of employees field
                        panel1.remove(numberOfEmployeesLabel);
                        panel1.remove(numberOfEmployeesField);
                    }

                    // re render frame
                    frame.revalidate();
                    frame.repaint();

                }
            }
        });

        // add the fields to the panel to the right and labels to the left
        panel1.add(categoryLabel);
        panel1.add(category);
        panel1.add(companyNameLabel);
        panel1.add(companyNameField);
        panel1.add(dateOfRegistrationLabel);
        panel1.add(dateOfRegistrationField);

        // if company is for profit, add number of employees field
        if (category.getSelectedIndex() == 1) {
            panel1.add(numberOfEmployeesLabel);
            panel1.add(numberOfEmployeesField);
        } else if (category.getSelectedIndex() == 2) {
            panel1.add(isItCharitableLabel);
            panel1.add(isItCharitableCheckBox);
        }

        panel1.add(submitLabel);
        panel1.add(submitButton);

        // set preferred size of panel 1
        panel1.setPreferredSize(new Dimension(450, 250));

        // set min size of panel 1
        panel1.setMinimumSize(new Dimension(400, 200));

        // set max size of panel 1
        panel1.setMaximumSize(new Dimension(550, 250));

        // set max for title panel
        titePanel.setMaximumSize(new Dimension(550, 50));

        /****************** PANEL 2 ******************/

        // create second panel
        JPanel panel2 = new JPanel();
        // set border red
        panel2.setBorder(BorderFactory.createLineBorder(Color.RED));
        // set background
        panel2.setBackground(Color.GRAY);
        // set size
        panel2.setPreferredSize(new Dimension(650, 300));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBorder(BorderFactory.createRaisedBevelBorder());
        // set round border
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        // add ttile to panel 2
        JLabel titleLabel2 = new JLabel("List of Companies");
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        // set height
        titleLabel2.setPreferredSize(new Dimension(650, 30));
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
        scrollPane.setPreferredSize(new Dimension(600, 200));
        // alogn center
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add the scroll pane to the panel
        panel2.add(scrollPane);

        // add textarea to scollpane
        scrollPane.setViewportView(textArea);

        // fix size of pannel 2
        panel2.setMinimumSize(new Dimension(500, 200));
        panel2.setMaximumSize(new Dimension(650, 400));

        // close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        closeButton.setBounds(50, 100, 90, 30);
        closeButton.setPreferredSize(new Dimension(90, 30));
        // align center
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        frame.setSize(700, 500);
        // SET FRAME MAX SIZE
        frame.setMaximumSize(new Dimension(700, 500));
        // set frame min size
        frame.setMinimumSize(new Dimension(700, 500));
        // set frame to non resizable
        frame.setResizable(false);

        // add the container panel to the frame
        frame.add(containerPanel);
        frame.pack(); // pack the frame
        frame.setVisible(true); // set frame visible

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
                String categ = categoryOptions[category.getSelectedIndex()];

                // write the data to file txt
                File file = new File("company.txt");

                // check if file exist (if not create a new file)
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        System.out.println("Error creating file");
                    }
                }

                try {
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);

                    br.write("Category: " + categ + "\n");
                    br.write("Company Name: " + companyName + "\n");
                    br.write("Date of Registration: " + dateOfRegistration + "\n");

                    if (categ == "For Profit") {
                        br.write("Number of Employees: " + numberOfEmployees + "\n");
                    } else {
                        br.write("Is it Charitable: " + isItCharitable + "\n");
                    }

                    br.write("\n----------------------------------------------------------------------------\n");

                    br.close();
                    fr.close();

                    System.out.println("Writting successful!");
                } catch (IOException e1) {
                    System.out.println("Error writing to file");
                }

                // add text to panel 2
                textArea.append("Category: " + categ + "\t");
                textArea.append("Company Name: " + companyName + "\t\n");
                textArea.append("Date of Registration: " + dateOfRegistration + "\t");

                if (categ == "For Profit") {
                    textArea.append("Number of Employees: " + numberOfEmployees + "\t");
                } else {
                    textArea.append("Is it Charitable: " + isItCharitable + "\t");
                }
                textArea.append("\n----------------------------------------------------------------------------\n");
            }
        });

    }
}