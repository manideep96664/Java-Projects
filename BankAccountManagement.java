import java.util.Scanner;

class BankAccount {
    private long accountNumber;
    private String accountHolderName;
    private double balance;

    
    public BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal of " + amount + " failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    
    public double checkBalance() {
        return balance;
    }

    
    public void displayAccount() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Current Balance     : " + checkBalance());
        System.out.println("---------------------------");
    }
}

public class BankAccountManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        long accountNumber = sc.nextLong();
        sc.nextLine(); 

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, name, initialBalance);

        System.out.print("Enter amount to deposit: ");
        account.deposit(sc.nextDouble());

        System.out.print("Enter amount to withdraw: ");
        account.withdraw(sc.nextDouble());

        account.displayAccount();

        sc.close();
    }
}