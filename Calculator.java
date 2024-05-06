import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class Calculator {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];      // Buttons for numbers (0, 1, 2, ...)
    JButton[] operationButtons = new JButton[4];    // Buttons for operations (+, -, *, /, sin, ... + delete, decimal etc)
    
    // Operation Buttons that will be added in the 'operationButtons' array:
    JButton divButton, mulButton, addButton, subbButton;
    JButton decButton, delButton, clrButton, eqButton;
    
    // Panel to hold all the buttons
    JPanel panel;

    // Font for the UI
    Font myFont = new Font("Poppins", Font.BOLD, 30);

    // Numbers that will be used for calculations
    double firstOperand = 0, secondOperand = 0, result = 0;

    // Variable to store the operator
    char operator;

    // Constructor for the Calculator class, which will start it
    Calculator() {
        frame = new JFrame("Calculator");                 // Initializing the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Allows for closing the calcultor permanently
        frame.setSize(400, 500);                   // Setting the width and height of the frame
        frame.setLayout(null);

        // Textfield
        textField = new JTextField();
        textField.setBounds(20, 30, 350, 50);  // Setting position and dimensions of the textfield in the frame
        textField.setFont(myFont);                              // Setting the font of text
        textField.setEditable(false);                         // Not allowing users to update the textfield directly
        


        // Adding all the components to the frame
        frame.add(textField);                                   // Adding the textfield
        frame.setVisible(true);                               // Shows the actual calculator
    }
}
