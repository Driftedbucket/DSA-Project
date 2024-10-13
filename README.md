# DSA-Project

Our phone book application is designed to manage and organize contact information efficiently. Our application consists of three primary classes: Contact, ContactManager, and PhoneBookGUI, along with a main entry point PhoneBookApp. Below is a description of how these classes work together to provide a smooth user experience.

1. PhoneBookGUI
The PhoneBookGUI class creates the graphical interface for our phone book application,
using JFrame to display a table of contacts alongside text fields for name and phone
number input. It includes buttons for adding, deleting, modifying, searching, and
sorting contacts, with a focus on a user-friendly design through custom colors and
fonts. The class also manages user interactions and updates the contact list dynamically.

2. Contact
The Contact class represents a single contact with a name and phone number. It includes a
constructor, getter and setter methods for accessing and modifying these attributes, and
implements the Comparable interface to allow sorting of contacts by name in a non case sensitive manner.

3. ContactManager
The ContactManager class manages a list of contacts stored in an ArrayList. It provides methods for
adding, deleting, and modifying contacts, as well as searching for contacts by name or phone number.
The class can also sort the contacts and retrieve the entire list.

4. PhoneBookApp
The PhoneBookApp class is the main entry point for our application.
It initializes a ContactManager and uses SwingUtilities.invokeLater
to safely create the PhoneBookGUI, linking the user interface to the
contact management logic and launching the application.

Contributors:                        Role:
Tapiwa Coffee 224027778              Invloved in the ContactManager class
Stephan Kabwe-Kibinda 224082299      Invloved in the PhoneBookGUI class
Nambahu Taunos Tangi 224066455       Involved in the PhoneBookGUI class
Sotama/Urib 224082272                Involved in the Contact class
Awike Gulu 224008595                 Invloved in the ContactManager class
Treasure TN Kazapua 224036572        Involved in the Contact class





