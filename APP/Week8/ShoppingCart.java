import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCart extends JFrame implements ActionListener {
    JCheckBox laptop, phone, headphones;
    JButton generateBill;
    JTextArea billArea;

    public ShoppingCart() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Item checkboxes
        laptop = new JCheckBox("Laptop - ₹60,000");
        phone = new JCheckBox("Phone - ₹30,000");
        headphones = new JCheckBox("Headphones - ₹3,000");

        // Button
        generateBill = new JButton("Generate Bill");
        generateBill.addActionListener(this);

        // Text area to display bill
        billArea = new JTextArea(10, 30);
        billArea.setEditable(false);

        // Add components to frame
        add(laptop);
        add(phone);
        add(headphones);
        add(generateBill);
        add(new JScrollPane(billArea));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int total = 0;
        StringBuilder bill = new StringBuilder("Selected Items:\n");

        if (laptop.isSelected()) {
            bill.append("- Laptop: ₹60,000\n");
            total += 60000;
        }
        if (phone.isSelected()) {
            bill.append("- Phone: ₹30,000\n");
            total += 30000;
        }
        if (headphones.isSelected()) {
            bill.append("- Headphones: ₹3,000\n");
            total += 3000;
        }

        bill.append("\nTotal Price: ₹").append(total);
        billArea.setText(bill.toString());
    }

    public static void main(String[] args) {
        new ShoppingCart();
    }
}
