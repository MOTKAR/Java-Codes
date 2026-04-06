// Assignment-4

import java.io.*;        // For FileWriter, IOException
import java.util.*;      // For Scanner, ArrayList

// USER-DEFINED EXCEPTION CLASSES

// Exception for minimum balance violation
class MinimumBalanceException extends Exception {
    MinimumBalanceException(String msg) {
        super(msg);  
    }
}

// Exception for invalid Customer ID
class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

// Exception for duplicate CID
class DuplicateCIDException extends Exception {
    DuplicateCIDException(String msg) {
        super(msg);
    }
}

// CUSTOMER CLASS 

// Class to store customer details
class Customer {
    int cid;        
    String cname;   
    double amount;  

    // Constructor to initialize customer details
    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    // Method to display customer details
    void display() {
        System.out.println("CID: " + cid + ", Name: " + cname + ", Balance: " + amount);
    }
}

public class assign_04{

    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    // ArrayList to store multiple customers
    static ArrayList<Customer> list = new ArrayList<>();

    // CREATE ACCOUNT FUNCTION 
    static void createAccount() {
        try {
            // Taking CID input
            System.out.print("Enter CID (1-20): ");
            int cid = sc.nextInt();
            sc.nextLine();

            // Checking CID range
            if (cid < 1 || cid > 20)
                throw new InvalidCIDException("CID must be between 1 and 20");

            for (Customer c : list) {
                if (c.cid == cid)
                    throw new DuplicateCIDException("CID " + cid + " already exists! No duplicates allowed.");
            }

            // Taking customer name
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // Taking initial balance
            System.out.print("Enter Initial Amount: ");
            double amount = sc.nextDouble();

            // Positive amount condition
            if (amount <= 0)
                throw new ArithmeticException("Amount must be positive");

            // Minimum balance condition
            if (amount < 1000)
                throw new MinimumBalanceException("Minimum balance should be Rs. 1000");

            // Creating new customer object
            Customer c = new Customer(cid, name, amount);

            // Adding customer to list
            list.add(c);

            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            // Catching all exceptions and printing error message
            System.out.println("Error: " + e.getMessage());
        }
    }
    // WITHDRAW FUNCTION
    static void withdraw() {
        try {
            // Input CID
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            // Input withdrawal amount
            System.out.print("Enter Withdraw Amount: ");
            double wth = sc.nextDouble();

            // Loop through customer list
            for (Customer c : list) {

                // Check if CID matches
                if (c.cid == cid) {

                    // Check insufficient balance
                    if (wth > c.amount)
                        throw new ArithmeticException("Insufficient Balance");

                    // Check positive amount
                    if (wth <= 0)
                        throw new ArithmeticException("Amount must be positive");

                    // Deduct amount
                    c.amount -= wth;

                    System.out.println("Withdrawal Successful!");
                    return; // Exit after successful transaction
                }
            }

            // If customer not found
            System.out.println("Customer not found!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SAVE TO FILE FUNCTION 
    static void saveToFile() {
        try {
            // Creating FileWriter object to write into file
            FileWriter fw = new FileWriter("customers.txt",true);

            // Writing each customer's data into file
            for (Customer c : list) {
                fw.write(c.cid + "," + c.cname + "," + c.amount + "\n");
            }

            // Closing file to save data
            fw.close();

            System.out.println("Data saved to file successfully!");

        } catch (IOException e) {
            // Handling file-related exceptions
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // DISPLAY FUNCTION 
    static void displayAll() {

        // Loop through all customers and display details
        for (Customer c : list) {
            c.display();
        }
    }

    // MAIN METHOD 
    public static void main(String[] args) {

        int choice; // Variable for menu choice

        do {
            // Displaying menu
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Display All");
            System.out.println("4. Save to File");
            System.out.println("5. Exit");

            // Taking user choice
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            // Switch case for menu operations
            switch (choice) {

                case 1:
                    createAccount(); // Call account creation
                    break;

                case 2:
                    withdraw(); // Call withdrawal function
                    break;

                case 3:
                    displayAll(); // Display all records
                    break;

                case 4:
                    saveToFile(); // Save data into file
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5); // Loop until user exits
    }
}
