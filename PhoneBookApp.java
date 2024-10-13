import javax.swing.*;

//Run this file to see our app in action!
public class PhoneBookApp {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        SwingUtilities.invokeLater(() -> new PhoneBookGUI(contactManager));
    }
}
