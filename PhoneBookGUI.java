import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PhoneBookGUI extends JFrame {
    private ContactManager contactManager;
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, phoneField, searchField;
    private JButton addButton, deleteButton, modifyButton, searchButton, sortButton;

    // Define colors
    private final Color BACKGROUND_COLOR = new Color(240, 240, 245);
    private final Color HEADER_COLOR = new Color(60, 60, 60);
    private final Color TEXT_COLOR = new Color(50, 50, 50);
    private final Color BUTTON_COLOR = new Color(100, 150, 200);
    private final Color BUTTON_TEXT_COLOR = Color.WHITE;

    public PhoneBookGUI(ContactManager contactManager) {
        this.contactManager = contactManager;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("shutyolameassupnigga");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(BACKGROUND_COLOR);

        createTable();
        createInputPanel();
        createButtonPanel();
        add(new JScrollPane(contactTable), BorderLayout.CENTER);
        add(createSearchPanel(), BorderLayout.NORTH);

        // Set custom font for the entire application
        setUIFont(new javax.swing.plaf.FontUIResource("Arial", Font.PLAIN, 14));

        setVisible(true);
    }

    private void createTable() {
        String[] columns = {"Name", "Phone Number"};
        tableModel = new DefaultTableModel(columns, 0);
        contactTable = new JTable(tableModel);
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactTable.setRowHeight(25);
        contactTable.setFont(new Font("Arial", Font.PLAIN, 14));
        contactTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        contactTable.getTableHeader().setBackground(HEADER_COLOR);
        contactTable.getTableHeader().setForeground(Color.WHITE);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(BACKGROUND_COLOR);

        nameField = createStyledTextField();
        phoneField = createStyledTextField();

        inputPanel.add(createStyledLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(createStyledLabel("Phone:"));
        inputPanel.add(phoneField);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        addButton = createStyledButton("Add");
        deleteButton = createStyledButton("Delete");
        modifyButton = createStyledButton("Modify");
        sortButton = createStyledButton("Sort");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(sortButton);

        add(buttonPanel, BorderLayout.EAST);

        addButton.addActionListener(e -> addContact());
        deleteButton.addActionListener(e -> deleteContact());
        modifyButton.addActionListener(e -> modifyContact());
        sortButton.addActionListener(e -> sortContacts());
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchPanel.setBackground(BACKGROUND_COLOR);
        searchField = createStyledTextField();
        searchButton = createStyledButton("Search");

        searchPanel.add(createStyledLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        searchButton.addActionListener(e -> searchContacts());

        return searchPanel;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField(20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                field.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return field;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BUTTON_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        return button;
    }



    private void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }
    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        if (!name.isEmpty() && !phone.isEmpty()) {
            Contact contact = new Contact(name, phone);
            contactManager.addContact(contact);
            updateTable();
            clearInputFields();
        }
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            contactManager.deleteContact(selectedRow);
            updateTable();
        }
    }

    private void modifyContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            if (!name.isEmpty() && !phone.isEmpty()) {
                Contact newContact = new Contact(name, phone);
                contactManager.modifyContact(selectedRow, newContact);
                updateTable();
                clearInputFields();
            }
        }
    }

    private void searchContacts() {
        String searchTerm = searchField.getText();
        List<Contact> searchResults = contactManager.searchContacts(searchTerm);
        updateTableWithResults(searchResults);
    }

    private void sortContacts() {
        contactManager.sortContacts();
        updateTable();
    }

    private void updateTable() {
        updateTableWithResults(contactManager.getAllContacts());
    }

    private void updateTableWithResults(List<Contact> contacts) {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.getName(), contact.getPhoneNumber()});
        }
    }

    private void clearInputFields() {
        nameField.setText("");
        phoneField.setText("");
    }
}
