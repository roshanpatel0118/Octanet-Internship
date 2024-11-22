import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // Constructor initializes account with default balance and PIN
    public ATMSimulation(double initialBalance, String initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
    }

    // Function to display current balance
    public void balanceInquiry() {
        System.out.println("Current balance: $" + balance);
        transactionHistory.add("Balance Inquiry: $" + balance);
    }

    // Function to withdraw cash
    public void cashWithdrawal(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Enter a valid amount to withdraw.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: $" + amount);
            transactionHistory.add("Cash Withdrawal: $" + amount);
        }
    }

    // Function to deposit cash
    public void cashDeposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount to deposit.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Amount deposited: $" + amount);
            transactionHistory.add("Cash Deposit: $" + amount);
        }
    }

    // Function to change PIN
    public void changePIN(String oldPin, String newPin) {
        if (!oldPin.equals(pin)) {
            System.out.println("Incorrect old PIN.");
        } else {
            pin = newPin;
            System.out.println("PIN changed successfully.");
            transactionHistory.add("PIN Change");
        }
    }

    // Function to display transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Main function to simulate ATM machine
    public static void main(String[] args) {
        ATMSimulation atm = new ATMSimulation(1000.0, "1234"); // Initial balance and default PIN
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Machine!");
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.balanceInquiry();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.cashWithdrawal(withdrawalAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.cashDeposit(depositAmount);
                    break;

                case 4:
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.next();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.next();
                    atm.changePIN(oldPin, newPin);
                    break;

                case 5:
                    atm.showTransactionHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
