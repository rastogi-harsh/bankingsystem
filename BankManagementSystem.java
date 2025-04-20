import java.util.*;

public class BankManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Search by Account Number");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> displayAllAccounts();
                case 3 -> searchAccount();
                case 4 -> depositMoney();
                case 5 -> withdrawMoney();
                case 6 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    static void createAccount() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // clear buffer
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        System.out.print("Enter initial balance: ₹");
        double balance = scanner.nextDouble();
        accounts.add(new BankAccount(name, accNumber, balance));
        System.out.println("Account created successfully!");
    }

    static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount acc : accounts) {
                acc.displayAccountDetails();
                System.out.println("---------------------");
            }
        }
    }

    static void searchAccount() {
        System.out.print("Enter account number to search: ");
        int accNumber = scanner.nextInt();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                acc.displayAccountDetails();
                return;
            }
        }
        System.out.println("Account not found.");
    }

    static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                System.out.print("Enter deposit amount: ₹");
                double amount = scanner.nextDouble();
                acc.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                System.out.print("Enter withdrawal amount: ₹");
                double amount = scanner.nextDouble();
                acc.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
