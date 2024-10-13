public class Contact implements Comparable<Contact> {

    private String name;
    private String phoneNumber;

    //This constructor initializes our Contact object with a specified name and phoneNumber.
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Our setter and getter methods
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    //This method allows for comparing two Contact objects based on their names.
    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
