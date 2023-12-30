import java.util.Scanner;
class BankAccount{
    private  int balance;
   public BankAccount(int intialAmmount){

       this.balance = intialAmmount;
   }

   public int getBalance(){

       return balance;
   }
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successfully Completed");
        } else {
            System.out.println("Invalid entry! Please enter a positive amount for the deposit.");
        }
    }
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            System.out.println("Withdrawal of " + amount + " Rs was successful.");
            balance -= amount; // Fix: Corrected the logic here
        } else {
            System.out.println("Invalid entry!! Insufficient balance and avoid entering a negative value ");
        }
    }
}

class ATM {

    private final   BankAccount account;

    public ATM(BankAccount account) {

        this.account = account;
    }

    public void display() {
        System.out.println("Choose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        try {
            do {
                display();
                System.out.println("Select an option");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Please enter the amount you'd like to deposit");
                        int depositAmount = sc.nextInt();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter the amount you want to withdraw");
                        int withdrawAmount = sc.nextInt();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: " + account.getBalance() + " Rs");
                        break;
                    case 4:
                        System.out.println("Thank you for choosing Hari Bank for your banking needs.");
                        break;
                    default:
                        System.out.println("Invalid entry!! Please choose a valid option from the provided menu.");
                }
            } while (option != 4);
        } finally {
            sc.close();
        }
    }
}
public class Task3_ATMInterface {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(20000);
        ATM atm = new ATM(userAccount);
        System.out.println("Please enter your PIN");
        String pin = sc.nextLine();
        if ("2002".equals(pin)) {
            atm.run();
        } else {
            System.out.println("Incorrect PIN");
        }

    }
}
