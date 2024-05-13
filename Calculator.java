import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
// import java.lang.reflect.Constructor;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // Buttons for numbers (0, 1, 2, ...)
    JButton[] operationButtons = new JButton[13]; // Buttons for operations (+, -, *, /, sin, ... + delete, decimal etc)

    // Operation Buttons that will be added in the 'operationButtons' array:
    JButton divButton, mulButton, addButton, subButton;
    JButton decButton, delButton, clrButton, equButton;
    JButton sqrtButton, sqrButton, modButton, inverseButton, negButton;
    // JButton sinButton, cosButton, tanButton, factorialButton;

    // Panel to hold all the buttons
    JPanel buttonsPanel;

    // Font for the UI
    Font myFont = new Font("Poppins", Font.BOLD, 20);

    // Numbers that will be used for calculations
    double firstOperand = 0, secondOperand = 0, result = 0;

    // Variable to store the operator
    char operator;

    // Constructor for the Calculator class, which will start it
    Calculator() {
        frame = new JFrame("Calculator"); // Initializing the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows for closing the calcultor permanently
        frame.setSize(400, 500); // Setting the width and height of the frame
        frame.setLayout(null);

        // Textfield
        textField = new JTextField();
        textField.setBounds(20, 30, 350, 50); // Setting position and dimensions of the textfield in the frame
        textField.setFont(myFont); // Setting the font of text
        textField.setEditable(false); // Not allowing users to update the textfield directly

        // Operation Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");
        equButton = new JButton("=");
        decButton = new JButton(".");
        sqrtButton = new JButton("√");
        sqrButton = new JButton("^2");
        modButton = new JButton("%");
        inverseButton = new JButton("1/x");

        // adding the operation buttons to the array
        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = decButton;
        operationButtons[5] = equButton;
        operationButtons[6] = delButton;
        operationButtons[7] = clrButton;
        operationButtons[8] = modButton;
        operationButtons[9] = sqrButton;
        operationButtons[10] = sqrtButton;
        operationButtons[11] = inverseButton;
        operationButtons[12] = negButton;

        delButton.setBounds(22, 410, 115, 50);
        negButton.setBounds(137, 410, 115, 50);
        clrButton.setBounds(252, 410,115, 50);

        // setting some properties to the buttons
        for (JButton button : operationButtons) {
            button.addActionListener(this); // allows to do something when interacted with the buttons
            button.setFont(myFont); // setting the font
            button.setFocusable(false);
        }

        // adding the number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this); // allows to do something when interacted with the buttons
            numberButtons[i].setFont(myFont); // setting the font
        }

        // initializing the panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4)); // grid of 5 buttons x 4 buttons
        buttonsPanel.setBounds(20, 100, 350, 300); // setting position and dimensions

        // adding the buttons to the panel (done manually for correct layout of buttons)
        buttonsPanel.add(inverseButton);
        buttonsPanel.add(modButton);
        buttonsPanel.add(sqrtButton);
        buttonsPanel.add(sqrButton);
        buttonsPanel.add(numberButtons[7]);
        buttonsPanel.add(numberButtons[8]);
        buttonsPanel.add(numberButtons[9]);
        buttonsPanel.add(mulButton);
        buttonsPanel.add(numberButtons[4]);
        buttonsPanel.add(numberButtons[5]);
        buttonsPanel.add(numberButtons[6]);
        buttonsPanel.add(addButton);
        buttonsPanel.add(numberButtons[1]);
        buttonsPanel.add(numberButtons[2]);
        buttonsPanel.add(numberButtons[3]);
        buttonsPanel.add(subButton);
        buttonsPanel.add(decButton);
        buttonsPanel.add(numberButtons[0]);
        buttonsPanel.add(equButton);
        buttonsPanel.add(divButton);

        // Adding all the components to the frame
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(buttonsPanel); // Adding the panel
        frame.add(textField); // Adding the textfield
        frame.setVisible(true); // Shows the actual calculator
    }

    // this fuction is used to add the functionality to the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        // number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i))); // adds the number to the textfield when the button is clicked
            }
        }

        if (e.getSource() == decButton && !textField.getText().contains(".") && !textField.getText().isEmpty()) { // decimal button
            textField.setText(textField.getText().concat("."));
        }

        // operation buttons
        if (e.getSource() == addButton) {                   // add button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        }
        if (e.getSource() == subButton) {                   // subtract button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                operator = '-';
            }
            textField.setText("");
        }
        if (e.getSource() == mulButton) {                   // multiply button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                operator = '*';
            }
            textField.setText("");
        }
        if (e.getSource() == divButton) {                   // divide button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                operator = '/';
            }
            textField.setText("");
        }
        if (e.getSource() == sqrButton) {                   // square button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                result = Math.pow(firstOperand, 2);
                textField.setText(String.valueOf(result));
            }
        }
        if (e.getSource() == sqrtButton) {                  // square root button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                result = Math.sqrt(firstOperand);
                textField.setText(String.valueOf(result));
            }

        }
        if (e.getSource() == inverseButton) {                   // inverse button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                result = 1 / firstOperand;
                System.out.println(result);
                textField.setText(String.valueOf(result));
            }
        }
        if (e.getSource() == modButton) {                   // modulus button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        }

        if (e.getSource() == inverseButton) {                   // inverse button
            if(!textField.getText().isEmpty())
            firstOperand = Double.parseDouble(textField.getText());
            result = 1 / firstOperand;
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton) {                   // clear button
            if (!textField.getText().isEmpty()) {
                textField.setText("");
            }
        }

        if (e.getSource() == delButton) {                   // delete button
            String currentText = textField.getText();

            if (!currentText.isEmpty()) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }

        }

        if(e.getSource() == equButton) {                    // equal button
            secondOperand = Double.parseDouble(textField.getText());
            if(operator == '+') {
                result = firstOperand + secondOperand;
                textField.setText(String.valueOf(result));
            }
            if(operator == '-') {
                result = firstOperand - secondOperand;
                textField.setText(String.valueOf(result));
            }
            if(operator == '*') {
                result = firstOperand * secondOperand;
                textField.setText(String.valueOf(result));
            }
            if(operator == '/') {
                if(secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    textField.setText(String.valueOf(result));
                } else {
                    textField.setText("No division by zero, dum dum");
                }
            }
        }

        if(e.getSource() == negButton) {                    // negative button
            String currentText = textField.getText();
            double temp = Double.parseDouble(currentText);

            if(!currentText.isEmpty() && temp != 0){
                temp = -temp;
                textField.setText(String.valueOf(temp));
            }
        }

    }
}
