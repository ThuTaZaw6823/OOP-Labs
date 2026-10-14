import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataEntryPage extends JFrame implements ActionListener {

    private MainPage mainPage;
    private JComboBox<String> productComboBox;
    private JComboBox<String> typeComboBox;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField flavorField;
    private JCheckBox[] roastBoxes;
    private ButtonGroup roastGroup;
    private JTextArea productArea;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton backButton;
    private JLabel statusLabel;
    private boolean loadingProducts;

    public DataEntryPage(MainPage mainPage) {
        this.mainPage = mainPage;

        setTitle("Manage Products - Coffee Shop");
        setSize(840, 640);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createForm();
        createButtons();
        createProductDisplay();

        refreshProducts();
        setVisible(true);
    }

    private void createForm() {
        JLabel titleLabel = new JLabel("Product Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(20, 15, 795, 35);
        add(titleLabel);

        addLabel("Select Product:", 65);
        productComboBox = new JComboBox<>();
        productComboBox.setBounds(160, 65, 625, 27);
        productComboBox.setActionCommand("Select Product");
        productComboBox.addActionListener(this);
        add(productComboBox);

        addLabel("Product Type:", 105);
        String[] productTypes = {"Coffee", "Dessert"};
        typeComboBox = new JComboBox<>(productTypes);
        typeComboBox.setBounds(160, 105, 625, 27);
        typeComboBox.setActionCommand("Change Type");
        typeComboBox.addActionListener(this);
        add(typeComboBox);

        addLabel("Name:", 145);
        nameField = makeTextField(145);

        addLabel("Price:", 185);
        priceField = makeTextField(185);
        priceField.setHorizontalAlignment(JTextField.LEFT);

        addLabel("Roast Level:", 225);
        roastGroup = new ButtonGroup();
        roastBoxes = createRoastBoxes(roastGroup);

        int[] positions = {160, 275, 395, 560};
        int[] widths = {105, 110, 155, 105};

        for (int i = 0; i < roastBoxes.length; i++) {
            roastBoxes[i].setBounds(positions[i], 225, widths[i], 27);
            add(roastBoxes[i]);
        }

        addLabel("Dessert Flavor:", 265);
        flavorField = makeTextField(265);
    }

    private void createButtons() {
        addButton = makeButton("Add Product", "Add", 20, 135);
        updateButton = makeButton("Update Selected", "Update", 165, 155);
        deleteButton = makeButton("Delete Selected", "Delete", 330, 155);
        clearButton = makeButton("New / Clear", "Clear", 495, 125);
        backButton = makeButton("Back to Main", "Back", 630, 155);
    }

    private void createProductDisplay() {
        JLabel storedLabel = new JLabel("Stored Products");
        storedLabel.setBounds(20, 355, 765, 25);
        add(storedLabel);

        productArea = new JTextArea();
        productArea.setEditable(false);
        productArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(productArea);
        scrollPane.setBounds(20, 385, 765, 160);
        add(scrollPane);

        statusLabel = new JLabel("Enter data, choose one roast for Coffee, and click Add Product.");
        statusLabel.setBounds(20, 555, 765, 30);
        add(statusLabel);
    }

    private void addLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(20, y, 135, 27);
        add(label);
    }

    private JTextField makeTextField(int y) {
        JTextField field = new JTextField();
        field.setBounds(160, y, 625, 27);
        add(field);

        return field;
    }

    private JButton makeButton(String text, String command, int x, int width) {
        JButton button = new JButton(text);
        button.setBounds(x, 315, width, 30);
        button.setActionCommand(command);
        button.addActionListener(this);
        add(button);

        return button;
    }

    static JCheckBox[] createRoastBoxes(ButtonGroup group) {
        String[] roastLevels = Coffee.getRoastLevels();
        JCheckBox[] boxes = new JCheckBox[roastLevels.length];

        for (int i = 0; i < roastLevels.length; i++) {
            JCheckBox box = new JCheckBox(roastLevels[i]);
            box.setActionCommand(roastLevels[i]);
            group.add(box);
            boxes[i] = box;
        }

        return boxes;
    }

    private void updateInputFields() {
        String selectedType = typeComboBox.getSelectedItem().toString();
        boolean coffeeSelected = selectedType.equals("Coffee");

        for (JCheckBox box : roastBoxes) {
            box.setEnabled(coffeeSelected);
        }

        flavorField.setEnabled(!coffeeSelected);
    }

    private ProductInterface readProductFromForm() {
        String productName = nameField.getText();
        String priceText = priceField.getText().trim();
        String selectedType = typeComboBox.getSelectedItem().toString();
        double productPrice;

        try {
            productPrice = Double.parseDouble(priceText);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Price must be a valid number.");
        }

        if (selectedType.equals("Coffee")) {
            if (roastGroup.getSelection() == null) {
                throw new IllegalArgumentException("Please choose one coffee roast level.");
            }

            String selectedRoast = roastGroup.getSelection().getActionCommand();
            return new Coffee(productName, productPrice, selectedRoast);
        }

        String flavor = flavorField.getText();
        return new Dessert(productName, productPrice, flavor);
    }

    private int getSelectedProductIndex() {
        return productComboBox.getSelectedIndex() - 1;
    }

    private void refreshProducts() {
        loadingProducts = true;

        productComboBox.removeAllItems();
        productComboBox.addItem("New Product");
        productArea.setText("");

        int productCount = Database.getProductCount();

        for (int i = 0; i < productCount; i++) {
            ProductInterface product = Database.getProduct(i);
            int displayNumber = i + 1;

            String selectionText = displayNumber + ". " + product.getType();
            selectionText += " - " + product.getName();
            productComboBox.addItem(selectionText);

            String productText = displayNumber + ". " + product.toString();
            productArea.append(productText + "\n");
        }

        if (productCount == 0) {
            productArea.setText("No products stored yet.");
        }

        productArea.setCaretPosition(0);
        loadingProducts = false;
        resetForm();
    }

    private void resetForm() {
        typeComboBox.setSelectedItem("Coffee");
        nameField.setText("");
        priceField.setText("");
        flavorField.setText("");
        roastGroup.clearSelection();

        updateInputFields();

        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void loadSelectedProduct() {
        int index = getSelectedProductIndex();

        if (index < 0) {
            resetForm();
            statusLabel.setText("Enter data and click Add Product.");
            return;
        }

        ProductInterface product = Database.getProduct(index);

        typeComboBox.setSelectedItem(product.getType());
        nameField.setText(product.getName());
        priceField.setText(Double.toString(product.getPrice()));
        roastGroup.clearSelection();
        flavorField.setText("");

        if (product instanceof Coffee) {
            Coffee coffee = (Coffee) product;

            for (JCheckBox box : roastBoxes) {
                if (box.getText().equals(coffee.getRoastLevel())) {
                    box.setSelected(true);
                }
            }
        } else if (product instanceof Dessert) {
            Dessert dessert = (Dessert) product;
            flavorField.setText(dessert.getFlavor());
        }

        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);

        statusLabel.setText("Edit the fields and click Update Selected, or click Delete Selected.");
    }

    private void addProduct() {
        ProductInterface newProduct = readProductFromForm();
        Database.addProduct(newProduct);

        refreshProducts();
        statusLabel.setText("Product added successfully.");
    }

    private void updateProduct() {
        int index = getSelectedProductIndex();
        ProductInterface replacement = readProductFromForm();
        Database.updateProduct(index, replacement);

        refreshProducts();
        statusLabel.setText("Product updated successfully.");
    }

    private void deleteProduct() {
        int index = getSelectedProductIndex();
        ProductInterface product = Database.getProduct(index);

        int answer = JOptionPane.showConfirmDialog(
                this,
                "Delete " + product.getName() + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            Database.deleteProduct(index);
            refreshProducts();
            statusLabel.setText("Product deleted successfully.");
        }
    }

    private void clearForm() {
        productComboBox.setSelectedIndex(0);
        resetForm();
        statusLabel.setText("Enter data and click Add Product.");
    }

    private void backToMain() {
        mainPage.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        try {
            if (command.equals("Select Product")) {
                if (!loadingProducts) {
                    loadSelectedProduct();
                }
            } else if (command.equals("Change Type")) {
                updateInputFields();
            } else if (command.equals("Add")) {
                addProduct();
            } else if (command.equals("Update")) {
                updateProduct();
            } else if (command.equals("Delete")) {
                deleteProduct();
            } else if (command.equals("Clear")) {
                clearForm();
            } else if (command.equals("Back")) {
                backToMain();
            }
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
