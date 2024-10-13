import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactManager {

    //initializing our arraylist
    private ArrayList<Contact> contacts;

    //Initializes contacts variable which stores an empty list
    public ContactManager() {
        contacts = new ArrayList<>();
    }
    
    //Adds a contact to our list
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    
    //Removes a contact using the contacts index
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    //Replaces the Contact at a specified index with a new Contact if the index is valid.
    public void modifyContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    //Searches for contacts whose names or phone numbers contain a given query string (case-insensitive).
    public List<Contact> searchContacts(String query) {
        List<Contact> results = new ArrayList<>();
        String lowercaseQuery = query.toLowerCase();
        for (int i = 0; i<contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().toLowerCase().contains(lowercaseQuery) || contact.getPhoneNumber().contains(lowercaseQuery)) {
                results.add(contact);
            }
        }
        return results;
    }

    //Sorts the contacts list using the compareTo method defined in the Contact class, which sorts by name.
    public void sortContacts() {
        Collections.sort(contacts);
    }

    //Returns a new ArrayList containing all contacts.
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}
