import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<String> contacts;
    private Scanner scanner;

    public Agenda() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Contact List Menu:");
            System.out.println("1. Display Contacts");
            System.out.println("2. Add Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
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
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayContacts() {
        System.out.println("Contacts:");
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    private void addContact() {
        System.out.print("Enter contact: ");
        String contact = scanner.next();
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private void deleteContact() {
        System.out.print("Enter contact to delete: ");
        String contact = scanner.next();
        if (contacts.remove(contact)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}