// uses Template method pattern here. 
import java.util.Scanner;

public abstract class Transaction {
    private double amount;

    // template mothod
    public final void makeTransaction(){
        recieverInfo();
        authenticate();
        takeAmount();
        boolean check = checkAmount();
        while(!check){
            System.out.println("Your balance is smaller than amount you want to transfer!");
            takeAmount();
        }
        transfer();
        updateBalance(amount);
    }

    public abstract void recieverInfo();
    public abstract void authenticate();
    public abstract void transfer();

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }

    public void takeAmount(){
        double amount;
        System.out.println("Enter the amount you want to transfer: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
        setAmount(amount);
    }

    public boolean checkAmount(){
        // check balance of account.
        return true;
    }

    public void updateBalance(double amount){
        // update balance in database and balance attribute in account.
    }

}
