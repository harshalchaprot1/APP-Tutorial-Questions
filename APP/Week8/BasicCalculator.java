import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicCalculator extends JFrame implements ActionListener {
    JTextField display = new JTextField();
    StringBuilder input = new StringBuilder();

    public BasicCalculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {"7", "8", "9", "C",
                            "4", "5", "6", "+", 
                            "1", "2", "3", "-", 
                            "0", "*", "/", "="};
        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("=")) {
            try {
                display.setText(String.valueOf(evaluate(input.toString())));
            } catch (Exception ex) {
                display.setText("Error");
            }
            input.setLength(0);
        } else if (cmd.equals("C")) {
            input.setLength(0);
            display.setText("");
        } else {
            input.append(cmd);
            display.setText(input.toString());
        }
    }

    private double evaluate(String expr) {
        String[] tokens = expr.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            double num = Double.parseDouble(tokens[i + 1]);
            switch (tokens[i]) {
                case "+": result += num; break;
                case "-": result -= num; break;
                case "*": result *= num; break;
                case "/": result /= num; break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}
