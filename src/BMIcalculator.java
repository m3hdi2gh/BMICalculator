import javax.swing.*;
import java.awt.*;

// Main class that starts the application
public class BMIcalculator  extends JFrame {
    public static void main(String[] args) {
        // Create a new instance of the StartFrame
        new StartFrame();
    }
}

// StartFrame class represents the initial frame where the user selects their gender
class StartFrame extends JFrame {
    StartFrame() {
        // Set the title, size, and default close operation of the frame
        setTitle("Start Page");
        setSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and add the Male and Female radio buttons
        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(140, 80, 70, 30);
        add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(260, 80, 70, 30);
        add(femaleButton);

        // Group the radio buttons so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        // Add action listeners to the radio buttons to open the FirstFrame when selected
        maleButton.addActionListener(e -> {
            new FirstFrame(this);
            dispose();
        });

        femaleButton.addActionListener(e -> {
            new FirstFrame(this);
            dispose();
        });

        // Make the frame visible
        setVisible(true);
    }
}

// FirstFrame class represents the frame where the user starts the BMI calculation
class FirstFrame extends JFrame {
    FirstFrame(StartFrame startFrame) {
        // Set the title, size, and default close operation of the frame
        setTitle("BMI Calculator");
        setSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and add labels and buttons
        JLabel label = new JLabel("BMI Calculator");
        label.setBounds(160, 40, 100, 50);
        add(label);

        JLabel note = new JLabel("This is a BMI Calculator app");
        note.setBounds(160, 80, 200, 50);
        add(note);

        JButton button = new JButton("Start");
        button.setBounds(250, 50, 70, 30);
        add(button);

        JButton backButton = new JButton("Back");
        backButton.setBounds(210, 135, 70, 30);
        add(backButton);

        // Add action listeners to the buttons
        button.addActionListener(e -> {
            new SecondFrame(this);
            dispose();
        });

        backButton.addActionListener(e -> {
            startFrame.setVisible(true);
            dispose();
        });

        // Make the frame visible
        setVisible(true);
    }
}

// SecondFrame class represents the frame where the user enters their height and weight and calculates their BMI
class SecondFrame extends JFrame {
    SecondFrame(FirstFrame firstFrame) {
        // Set the title, size, and default close operation of the frame
        setTitle("BMI Calculator");
        setSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and add labels, text fields, and buttons
        JLabel secondLabel = new JLabel("Enter Height (cm):");
        secondLabel.setBounds(100, 40, 200, 50);
        add(secondLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(210, 50, 100, 30);
        add(heightField);

        JLabel thirdLabel = new JLabel("Enter Weight (kg):");
        thirdLabel.setBounds(100, 100, 200, 50);
        add(thirdLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(210, 110, 100, 30);
        add(weightField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 160, 100, 30);
        add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(210, 160, 100, 30);
        add(backButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(155, 185, 200, 50);
        add(resultLabel);

        // Add action listeners to the buttons
        backButton.addActionListener(e -> {
            firstFrame.setVisible(true);
            dispose();
        });

        calculateButton.addActionListener(e -> {
            // Calculate the BMI and display the result
            double height = Double.parseDouble(heightField.getText()) / 100;
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
        });

        // Make the frame visible
        setVisible(true);
    }
}