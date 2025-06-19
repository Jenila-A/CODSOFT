import java.util.Scanner;
// Main class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

// BankAccount class to store balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// ATM class with UI
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🏧 Welcome to the ATM Machine!");
        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please choose between 1 and 4.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("💰 Your current balance is: ₹" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful. Updated balance: ₹" + account.getBalance());
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. Remaining balance: ₹" + account.getBalance());
        } else {
            System.out.println("❌ Withdrawal failed. Either amount is invalid or insufficient balance.");
        }
    }
}
    