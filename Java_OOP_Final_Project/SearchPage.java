import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SearchPage extends JFrame implements ActionListener {

    private MainPage mainPage;
    private JComboBox<String> criterionComboBox;
    private JTextField valueField;
    private JComboBox<String> roastComboBox;
    private JTextArea resultArea;
    private JButton searchButton;
    private JButton backButton;

    public SearchPage(MainPage mainPage) {
        this.mainPage = mainPage;

        setTitle("Search Products - Coffee Shop");
        setSize(840, 480);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createSearchFields();
        createButtons();
        createResultArea();

        setVisible(true);
    }

    private void createSearchFields() {
        JLabel titleLabel = new JLabel("Product Search", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(20, 15, 795, 35);
        add(titleLabel);

        JLabel criterionLabel = new JLabel("Search Criterion:");
        criterionLabel.setBounds(20, 70, 140, 27);
        add(criterionLabel);

        String[] criteria = {
            "Name Contains",
            "Maximum Price",
            "Coffee Roast Level",
            "Dessert Flavor"
        };

        criterionComboBox = new JComboBox<>(criteria);
        criterionComboBox.setBounds(170, 70, 615, 27);
        criterionComboBox.setActionCommand("Change Criterion");
        criterionComboBox.addActionListener(this);
        add(criterionComboBox);

        JLabel valueLabel = new JLabel("Search Value:");
        valueLabel.setBounds(20, 110, 140, 27);
        add(valueLabel);

        valueField = new JTextField();
        valueField.setBounds(170, 110, 615, 27);
        valueField.setActionCommand("Search");
        valueField.addActionListener(this);
        add(valueField);

        roastComboBox = new JComboBox<>(Coffee.getRoastLevels());
        roastComboBox.setBounds(170, 110, 615, 27);
        roastComboBox.setVisible(false);
        add(roastComboBox);
    }

    private void createButtons() {
        searchButton = new JButton("Search");
        searchButton.setBounds(170, 155, 130, 30);
        searchButton.setActionCommand("Search");
        searchButton.addActionListener(this);
        add(searchButton);

        backButton = new JButton("Back to Main");
        backButton.setBounds(310, 155, 150, 30);
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        add(backButton);
    }

    private void createResultArea() {
        resultArea = new JTextArea("Choose a criterion and click Search.");
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(20, 210, 765, 195);
        add(scrollPane);
    }

    static String findProducts(String criterion, String value) {
        if (criterion == null || value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter or choose a search value.");
        }

        boolean nameSearch = criterion.equals("Name Contains");
        boolean priceSearch = criterion.equals("Maximum Price");
        boolean coffeeSearch = criterion.equals("Coffee Roast Level");
        boolean dessertSearch = criterion.equals("Dessert Flavor");

        if (!nameSearch && !priceSearch && !coffeeSearch && !dessertSearch) {
            throw new IllegalArgumentException("Choose a valid search criterion.");
        }

        String searchValue = value.trim();
        double maximumPrice = 0;

        if (priceSearch) {
            try {
                maximumPrice = Double.parseDouble(searchValue);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("Maximum price must be a valid number.");
            }

            if (!Double.isFinite(maximumPrice) || maximumPrice < 0) {
                throw new IllegalArgumentException(
                        "Maximum price must be a finite number of 0 or more.");
            }
        }

        String results = "";
        int matchCount = 0;

        for (int i = 0; i < Database.getProductCount(); i++) {
            ProductInterface product = Database.getProduct(i);
            boolean matches = false;

            if (nameSearch) {
                String productName = product.getName().toLowerCase(Locale.ROOT);
                String enteredName = searchValue.toLowerCase(Locale.ROOT);
                matches = productName.contains(enteredName);
            } else if (priceSearch) {
                matches = product.getPrice() <= maximumPrice;
            } else if (coffeeSearch && product instanceof Coffee) {
                Coffee coffee = (Coffee) product;
                matches = coffee.getRoastLevel().equalsIgnoreCase(searchValue);
            } else if (dessertSearch && product instanceof Dessert) {
                Dessert dessert = (Dessert) product;
                matches = dessert.getFlavor().equalsIgnoreCase(searchValue);
            }

            if (matches) {
                matchCount++;
                results += product.toString() + "\n";
            }
        }

        if (matchCount == 0) {
            return "No matching products found.";
        }

        return "Products found: " + matchCount + "\n\n" + results;
    }

    private void updateSearchInput() {
        String criterion = criterionComboBox.getSelectedItem().toString();
        boolean roastSearch = criterion.equals("Coffee Roast Level");

        valueField.setVisible(!roastSearch);
        roastComboBox.setVisible(roastSearch);
        resultArea.setText("Choose a search value and click Search.");
    }

    private void searchProducts() {
        String criterion = criterionComboBox.getSelectedItem().toString();
        String searchValue;

        if (criterion.equals("Coffee Roast Level")) {
            searchValue = roastComboBox.getSelectedItem().toString();
        } else {
            searchValue = valueField.getText();
        }

        try {
            String results = findProducts(criterion, searchValue);
            resultArea.setText(results);
            resultArea.setCaretPosition(0);
        } catch (IllegalArgumentException exception) {
            resultArea.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void backToMain() {
        mainPage.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Change Criterion")) {
            updateSearchInput();
        } else if (command.equals("Search")) {
            searchProducts();
        } else if (command.equals("Back")) {
            backToMain();
        }
    }
}
