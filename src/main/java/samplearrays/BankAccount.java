package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000] ;
    int currentTransactionIndex = 0;


    public BankAccount(String name, int startingBalance){
        this.name = name ;
        this.currentBalance = startingBalance ;
    }

    public void deposit(double amount){
        if (amount>=0) {
            transactions[currentTransactionIndex] = amount;
            currentTransactionIndex++;
            this.currentBalance += amount ;
            System.out.println(this.name + " deposited an amount of: " + amount + ".");
            this.displayBalance();
        }
        else { System.out.println("Unsuccessful deposit") ; }
    }

    public void withdraw(double amount){
        if (amount>=0 && this.currentBalance>=amount){
            transactions[currentTransactionIndex] = -amount;
            currentTransactionIndex++;
            this.currentBalance -= amount ;
            System.out.println(this.name + " withdrawed an amount of: " + amount + ".");
            this.displayBalance();
        }
        else { System.out.println("Unsuccessful withdrawal") ; }
    }

    public void displayTransactions(){
        System.out.println(this.name + "'s transactions: ");
        System.out.println("Deposits: ");
        for (int i = 0; i < currentTransactionIndex; i++) {
            if (transactions[i] >= 0) {
                System.out.println(transactions[i]);
            }
        }
        System.out.println("Withdrawals : ");
        for (int i = 0; i < currentTransactionIndex; i++) {
            if (transactions[i] < 0) {
                System.out.println(-transactions[i]);
            }
        }
    }

    public void displayBalance(){
        System.out.println("Balance: " + this.currentBalance) ;
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
