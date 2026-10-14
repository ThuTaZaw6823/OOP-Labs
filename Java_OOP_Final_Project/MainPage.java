import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainPage extends JFrame implements ActionListener {
    private JButton dataEntryButton;
    private JButton searchButton;
    private JButton exitButton;

    public MainPage() {
        setTitle("Family Coffee Shop Management System");
        setSize(470, 300);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Coffee Shop Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(15, 20, 440, 35);
        add(titleLabel);

        dataEntryButton = makeMenuButton("Manage Products", "Manage", 80);
        searchButton = makeMenuButton("Search Products", "Search", 130);
        exitButton = makeMenuButton("Exit", "Exit", 180);

        setVisible(true);
    }

    private JButton makeMenuButton(String text, String command, int y) {
        JButton button = new JButton(text);
        button.setBounds(120, y, 230, 35);
        button.setActionCommand(command);
        button.addActionListener(this);
        add(button);
        
        return button;
    }

    private void openDataEntryPage() {
        new DataEntryPage(this);
        setVisible(false);
    }

    private void openSearchPage() {
        new SearchPage(this);
        setVisible(false);
    }

    private void exitApplication() {
        int answer = JOptionPane.showConfirmDialog(
                this,
                "Do you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Manage")) {
            openDataEntryPage();
        } else if (command.equals("Search")) {
            openSearchPage();
        } else if (command.equals("Exit")) {
            exitApplication();
        }
    }

    public static void main(String[] args) {
        new MainPage();
    }
}
