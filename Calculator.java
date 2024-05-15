import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // Buttons for numbers (0, 1, 2, ...)
    JButton[] calculationButtons = new JButton[21]; // Buttons for operations (+, -, .. ,  decimal and number buttons etc)

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem standardMode, scientificMode;

    // buttons to add to standard buttons panel
    JButton divButton, mulButton, addButton, subButton;
    JButton decButton, delButton, clrButton, equButton;

    // buttons to add to scientific buttons panel
    JButton sinButton, cosButton, tanButton, logButton;
    JButton secButton, cosecButton, cotButton, factorialButton;
    JButton sqrtButton, sqrButton, modButton, inverseButton, negButton;
    

    // Panel to hold all the buttons
    JPanel standardButtonsPanel;                  // used to hold standard calculation buttons
    JPanel scientificButtonsPanel;                // used to hold scientific calculation buttons
    JPanel numpadPanel;

    // Fonts for the UI
    Font myFont = new Font("Poppins", Font.BOLD, 17);
    Font numpadFont = new Font("Poppins", Font.BOLD, 25);

    // Numbers that will be used for calculations
    double firstOperand = 0, secondOperand = 0, result = 0;

    // Variable to store the operator
    char operator;

    // Constructor for the Calculator class, which will start it
    Calculator() {
        frame = new JFrame("Calculator"); // Initializing the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            // Allows for closing the calcultor permanently
        frame.setSize(400, 550);                            // Setting the width and height of the frame
        frame.setLayout(null); 
        frame.getContentPane().setBackground(new Color(5, 5, 5));  //Setting background color
        frame.setResizable(false);

        // Textfield
        textField = new JTextField();
        textField.setBounds(20, 30, 350, 50);       // Setting position and dimensions of the textfield in the frame
        textField.setFont(myFont);                                   // Setting the font of text
        textField.setEditable(false);                              // Not allowing users to update the textfield directly
        textField.setBackground(new Color(31, 31, 31));        // setting background color
        textField.setForeground(new Color(235, 235, 235));     // setting font color
        textField.setBorder(null);                            // removing border

        menuBar = new JMenuBar();                                    // initializing menubar
        menu = new JMenu("Modes");                                 // initializing menu

        standardMode = new JMenuItem("Standard");               // initializing menu items
        standardMode.addActionListener(this);
        scientificMode = new JMenuItem("Scientific");           // ...
        scientificMode.addActionListener(this);

        menu.add(standardMode);                                      // adding menu items to menu
        menu.add(scientificMode);                                    // ...

        menuBar.add(menu);                                           // adding menu to menubar
        menuBar.setVisible(true);                              // setting menubar visible 

        // Standard Buttons
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

        // scientific buttons
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        secButton = new JButton("sec");
        cosecButton = new JButton("cosec");
        cotButton = new JButton("cot");
        factorialButton = new JButton("!");

        // adding the standard operation buttons to the array
        calculationButtons[0] = addButton;
        calculationButtons[1] = subButton;
        calculationButtons[2] = mulButton;
        calculationButtons[3] = divButton;
        calculationButtons[4] = decButton;
        calculationButtons[5] = equButton;
        calculationButtons[6] = delButton;
        calculationButtons[7] = clrButton;
        calculationButtons[8] = modButton;
        calculationButtons[9] = sqrButton;
        calculationButtons[10] = sqrtButton;
        calculationButtons[11] = inverseButton;
        calculationButtons[12] = negButton;
        calculationButtons[13] = sinButton;
        calculationButtons[14] = cosButton;
        calculationButtons[15] = tanButton;
        calculationButtons[16] = logButton;
        calculationButtons[17] = secButton;
        calculationButtons[18] = cosecButton;
        calculationButtons[19] = cotButton;
        calculationButtons[20] = factorialButton;

        delButton.setBounds(20, 410, 113, 50);
        negButton.setBounds(137, 410, 115, 50);
        clrButton.setBounds(256, 410,113, 50);

        // setting some properties to the standard operations buttons
        for (JButton button : calculationButtons) {
            button.addActionListener(this); // allows to do something when interacted with the buttons
            button.setFont(myFont); // setting the font
            button.setFocusable(false);
            button.setContentAreaFilled(false);
            button.setBackground(new Color(105, 105, 105)); // setting background color
            button.setForeground(new Color(235, 235, 235)); // setting foreground color
            button.setFocusPainted(false);
        }
        
        // adding the number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this); // allows to do something when interacted with the buttons
            numberButtons[i].setFont(numpadFont); // setting the font
            numberButtons[i].setContentAreaFilled(false);
            numberButtons[i].setBackground(new Color(105, 105, 105)); // setting background color
            numberButtons[i].setForeground(new Color(235, 235, 235)); // setting foreground color
            numberButtons[i].setFocusPainted(false);
        }

        // initializing numpad panel
        numpadPanel = new JPanel();
        numpadPanel.setLayout(new GridLayout(0, 3, 3, 3));
        numpadPanel.setBounds(22, 250, 260, 150);
        numpadPanel.setBackground(null);
        
        // initializing the standard operation buttons panel
        standardButtonsPanel = new JPanel();
        standardButtonsPanel.setLayout(new GridLayout(4, 0, 3, 3)); // 4 rows
        standardButtonsPanel.setBounds(275, 250, 90, 150); // setting position and dimensions
        standardButtonsPanel.setBackground(null);
        
        //initializing the scientific operation buttons panel
        scientificButtonsPanel = new JPanel();
        scientificButtonsPanel.setLayout(new GridLayout(0, 4, 3, 3)); // 1 column 
        scientificButtonsPanel.setBounds(22, 93, 345, 150); // setting position and dimensions
        scientificButtonsPanel.setBackground(null);
        
        // numpad panel
        numpadPanel.add(numberButtons[7]);
        numpadPanel.add(numberButtons[8]);
        numpadPanel.add(numberButtons[9]);
        numpadPanel.add(numberButtons[4]);
        numpadPanel.add(numberButtons[5]);
        numpadPanel.add(numberButtons[6]);
        numpadPanel.add(numberButtons[1]);
        numpadPanel.add(numberButtons[2]);
        numpadPanel.add(numberButtons[3]);
        numpadPanel.add(decButton);
        numpadPanel.add(numberButtons[0]);
        numpadPanel.add(equButton);
        
        // adding the standard buttons to the panel (done manually for correct layout of buttons)
        standardButtonsPanel.add(addButton);
        standardButtonsPanel.add(subButton);
        standardButtonsPanel.add(mulButton);
        standardButtonsPanel.add(divButton);

        // scientific buttons
        scientificButtonsPanel.add(inverseButton);
        scientificButtonsPanel.add(modButton);
        scientificButtonsPanel.add(sqrtButton);
        scientificButtonsPanel.add(sqrButton);
        scientificButtonsPanel.add(sinButton);
        scientificButtonsPanel.add(cosButton);
        scientificButtonsPanel.add(tanButton);
        scientificButtonsPanel.add(logButton);
        scientificButtonsPanel.add(secButton);
        scientificButtonsPanel.add(cosecButton);
        scientificButtonsPanel.add(cotButton);
        scientificButtonsPanel.add(factorialButton);
        

        // Adding all the components to the frame
        frame.add(numpadPanel);
        frame.setJMenuBar(menuBar);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(standardButtonsPanel); // Adding the standard panel
        frame.add(scientificButtonsPanel); // Adding the standard panel
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
                result = 0;
            }
        }
        if (e.getSource() == sqrtButton) {                  // square root button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                result = Math.sqrt(firstOperand);
                textField.setText(String.valueOf(result));
                result = 0;
            }

        }
        if (e.getSource() == inverseButton) {                   // inverse button
            if (!textField.getText().isEmpty()) {
                firstOperand = Double.parseDouble(textField.getText());
                result = 1 / firstOperand;
                System.out.println(result);
                textField.setText(String.valueOf(result));
                result = 0;
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
            result = 0;
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
            result = 0;
        }

        if(e.getSource() == negButton) {                    // negative button
            String currentText = textField.getText();
            double temp = Double.parseDouble(currentText);
            
            if(!currentText.isEmpty() && temp != 0){
                temp = -temp;
                textField.setText(String.valueOf(temp));
            }
        }

        if(e.getSource() == sinButton) {                                // sin button
            firstOperand = Double.parseDouble(textField.getText());
            result = Math.sin(firstOperand);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == cosButton) {                                // cos button
            firstOperand = Double.parseDouble(textField.getText());
            result = Math.cos(firstOperand);
            textField.setText(String.valueOf(result));
            
        }
        if(e.getSource() == tanButton) {                                // tan button
            firstOperand = Double.parseDouble(textField.getText());
            result = Math.tan(firstOperand);
            textField.setText(String.valueOf(result));
            
        }
        if(e.getSource() == logButton) {                                // log button
            firstOperand = Double.parseDouble(textField.getText());
            result = Math.log(firstOperand);
            textField.setText(String.valueOf(result));
            
        }
        if(e.getSource() == secButton) {                                // sec button
            firstOperand = Double.parseDouble(textField.getText());
            result = 1/Math.cos(firstOperand);
            textField.setText(String.valueOf(result));
            
        }
        if(e.getSource() == cosecButton) {                                // cosec button
            firstOperand = Double.parseDouble(textField.getText());
            result = 1/Math.sin(firstOperand);
            textField.setText(String.valueOf(result));
            
        }
        if(e.getSource() == cotButton) {                                // cot button
            firstOperand = Double.parseDouble(textField.getText());
            result = 1/Math.tan(firstOperand);
            textField.setText(String.valueOf(result));

        }
        if(e.getSource() == factorialButton) {                                // factorial button
            firstOperand = Double.parseDouble(textField.getText());
            result = factorial(firstOperand);
            textField.setText(String.valueOf(result));
        }

        // Changing modes
        if(e.getSource() == standardMode) {                                         // switch to standard mode
            frame.remove(scientificButtonsPanel);
            numpadPanel.setBounds(20, 100, 248, 300);
            standardButtonsPanel.setBounds(270, 100, 98, 300);
            
            frame.revalidate();
            frame.repaint();
        }
        if(e.getSource() == scientificMode) {                                       // switch to scientific mode
            frame.add(scientificButtonsPanel);
            standardButtonsPanel.setBounds(275, 250, 90, 150);
            numpadPanel.setBounds(22, 250, 260, 150);

            frame.revalidate();
            frame.repaint();
        }
    }

    public static double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}