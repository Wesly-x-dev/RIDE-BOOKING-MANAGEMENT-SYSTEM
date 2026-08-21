import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingApp extends JFrame {

    private static final String INPUT_PANEL = "InputPanel";
    private static final String GREETING_PANEL = "GreetingPanel";

    private CardLayout cardLayout;
    private JPanel cardContainer;

    private JTextField nameField;
    private JTextArea greetingArea;

    public GreetingApp() {
        setTitle("Greeting App");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);

        cardContainer.add(createInputPanel(), INPUT_PANEL);
        cardContainer.add(createGreetingPanel(), GREETING_PANEL);

        add(cardContainer);

        cardLayout.show(cardContainer, INPUT_PANEL);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter your username:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(150, 25));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSubmit();
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(submitButton);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private JPanel createGreetingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        greetingArea = new JTextArea();
        greetingArea.setEditable(false);
        greetingArea.setLineWrap(true);
        greetingArea.setWrapStyleWord(true);
        greetingArea.setFont(new Font("SansSerif", Font.PLAIN, 14));

        panel.add(new JScrollPane(greetingArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNext();
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void onSubmit() {
        String username = nameField.getText().trim();
        if (username.isEmpty()) {
            username = "there";
        }
        greetingArea.setText("Hi, " + username + "!");
        cardLayout.show(cardContainer, GREETING_PANEL);
    }

    private void onBack() {
        // Go back to the input panel, keeping whatever was typed before
        cardLayout.show(cardContainer, INPUT_PANEL);
    }

    private void onNext() {
        // Go back to the input panel with all fields cleared for a new entry
        nameField.setText("");
        greetingArea.setText("");
        cardLayout.show(cardContainer, INPUT_PANEL);
        nameField.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GreetingApp().setVisible(true);
            }
        });
    }
}