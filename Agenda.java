import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactList() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Contact List Menu:");
            System.out.println("1. Display Contacts");
            System.out.println("2. Add Contact");
            System.out.println("3. Modify Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayContacts() {
        System.out.println("Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private void modifyContact() {
        System.out.print("Enter name of contact to modify: ");
        String name = scanner.next();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.next();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Contact modified successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    private void deleteContact() {
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.next();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

