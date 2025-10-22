import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeedbackForm extends JFrame implements ActionListener {
    JRadioButton[] stars = new JRadioButton[5];
    ButtonGroup starGroup = new ButtonGroup();
    JTextArea commentArea = new JTextArea(5, 30);
    JButton submitButton = new JButton("Submit");

    public FeedbackForm() {
        setTitle("Online Feedback Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel ratingPanel = new JPanel(new FlowLayout());
        ratingPanel.setBorder(BorderFactory.createTitledBorder("Rate our service (1 to 5 stars)"));
        for (int i = 0; i < 5; i++) {
            stars[i] = new JRadioButton((i + 1) + " ★");
            starGroup.add(stars[i]);
            ratingPanel.add(stars[i]);
        }

        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBorder(BorderFactory.createTitledBorder("Your Comments"));
        commentPanel.add(new JScrollPane(commentArea), BorderLayout.CENTER);

        submitButton.addActionListener(this);

        add(ratingPanel, BorderLayout.NORTH);
        add(commentPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int rating = -1;
        for (int i = 0; i < 5; i++) if (stars[i].isSelected()) rating = i + 1;
        String comments = commentArea.getText().trim();

        if (rating == -1 || comments.isEmpty())
            JOptionPane.showMessageDialog(this, "Please select a rating and enter your comments.");
        else {
            JOptionPane.showMessageDialog(this, "Thank you for your feedback!\nRating: " + rating + " ★\nComments: " + comments);
            starGroup.clearSelection(); commentArea.setText("");
        }
    }

    public static void main(String[] args) {
        new FeedbackForm();
    }
}
