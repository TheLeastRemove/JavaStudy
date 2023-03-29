package Solutions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField inputField;
    private JPanel buttonPanel;

    public Calculator() {
        super("模拟计算器—江海大");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setEditable(false);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {"%", "C", "←", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(inputField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String command = e.getActionCommand();
        if (command.equals("C")) {
            inputField.setText("");
        } else if (command.equals("←")) {
            if (input.length() > 0) {
                inputField.setText(input.substring(0, input.length() - 1));
            }
        } else if (command.equals("+/-")) {
            if (input.length() > 0 && !input.equals("0")) {
                if (input.charAt(0) == '-') {
                    inputField.setText(input.substring(1));
                } else {
                    inputField.setText("-" + input);
                }
            }
        } else if (command.equals("=")) {
            double result = calculate(input);
            inputField.setText(Double.toString(result));
        } else {
            inputField.setText(input + command);
        }
    }

    private double calculate(String input) {
        double result = 0;
        char op = '+';
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9' || c == '.') {
                int j = i;
                while (j < input.length() && (input.charAt(j) >= '0' && input.charAt(j) <= '9' || input.charAt(j) == '.')) {
                    j++;
                }
                double num = Double.parseDouble(input.substring(i, j));
                if (op == '+') {
                    result += num;
                } else if (op == '-') {
                    result -= num;
                } else if (op == '*') {
                    result *= num;
                } else if (op == '/') {
                    result /= num;
                }
                i = j;
            } else {
                op = c;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
