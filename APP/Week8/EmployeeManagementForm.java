import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class EmployeeManagementForm extends JFrame implements ActionListener {
    JTextField nameField = new JTextField(), deptField = new JTextField(), salaryField = new JTextField();
    JButton submitButton = new JButton("Add Employee"), showDetailsButton = new JButton("Show Details"), exitButton = new JButton("Exit");
    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", "Department", "Salary"}, 0);
    JTable employeeTable = new JTable(tableModel);
    ArrayList<String[]> employeeList = new ArrayList<>();

    public EmployeeManagementForm() {
        setTitle("Employee Management Form");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Department:")); inputPanel.add(deptField);
        inputPanel.add(new JLabel("Salary:")); inputPanel.add(salaryField);
        inputPanel.add(submitButton); inputPanel.add(exitButton);

        submitButton.addActionListener(this);
        exitButton.addActionListener(e -> System.exit(0));
        showDetailsButton.addActionListener(this);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);
        add(showDetailsButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText().trim(), dept = deptField.getText().trim(), salaryStr = salaryField.getText().trim();
            if (name.isEmpty() || dept.isEmpty() || salaryStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields."); return;
            }
            try {
                double salary = Double.parseDouble(salaryStr);
                employeeList.add(new String[]{name, dept, String.valueOf(salary)});
                nameField.setText(""); deptField.setText(""); salaryField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Salary must be a number.");
            }
        } else if (e.getSource() == showDetailsButton) {
            tableModel.setRowCount(0);
            for (String[] emp : employeeList) tableModel.addRow(emp);
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementForm();
    }
}
