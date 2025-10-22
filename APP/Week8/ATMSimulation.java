import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMSimulation extends JFrame implements ActionListener {
    JPasswordField pinField;
    JButton loginButton;
    JPanel mainPanel, actionPanel;
    JButton checkBalanceBtn, depositBtn, withdrawBtn;
    JLabel messageLabel;
    double balance = 2000.0; // Initial balance
    final String correctPIN = "1234";

    public ATMSimulation() {
        setTitle("ATM Simulation");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Login Panel
        mainPanel = new JPanel(new FlowLayout());
        mainPanel.add(new JLabel("Enter PIN:"));
        pinField = new JPasswordField(10);
        mainPanel.add(pinField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        mainPanel.add(loginButton);

        messageLabel = new JLabel("");
        mainPanel.add(messageLabel);

        add(mainPanel, BorderLayout.NORTH);

        // Action Panel
        actionPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        checkBalanceBtn = new JButton("Check Balance");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");

        checkBalanceBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);

        actionPanel.add(checkBalanceBtn);
        actionPanel.add(depositBtn);
        actionPanel.add(withdrawBtn);
        actionPanel.setVisible(false);

        add(actionPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enteredPIN = new String(pinField.getPassword());
            if (enteredPIN.equals(correctPIN)) {
                messageLabel.setText("Access Granted ✅");
                actionPanel.setVisible(true);
            } else {
                messageLabel.setText("Invalid PIN ❌");
                actionPanel.setVisible(false);
            }
        } else if (e.getSource() == checkBalanceBtn) {
            JOptionPane.showMessageDialog(this, "Current Balance: ₹" + balance);
        } else if (e.getSource() == depositBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter deposit amount:");
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    balance += amount;
                    JOptionPane.showMessageDialog(this, "₹" + amount + " Deposited. New Balance: ₹" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Enter a valid amount.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        } else if (e.getSource() == withdrawBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "₹" + amount + " Withdrawn. New Balance: ₹" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient balance or invalid amount.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        new ATMSimulation();
    }
}
