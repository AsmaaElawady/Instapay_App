// uses Template method pattern here. 
import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Transaction {
    public dummyData data;
    public DataBase db;
    private Account sender;
    private double amount;

    public Transaction(){
        data = new dummyData();
    }

    public void setSender(Account sender){
        this.sender = sender;
    }

    public void setDB(DataBase db){
        this.db = db;
        ArrayList<bankUser> bankUsers;
        bankUsers = data.getMybank().getBankUsers();
        db.addBankUsers(bankUsers);
        ArrayList<walletUser> walletUsers;
        walletUsers = data.getMyWallet().walletUsers;
        db.addWalletUsers(walletUsers);
    }

    public DataBase getDB(){
        return this.db;
    }

    public Account getSender(){
        return this.sender;
    }

    // template mothod
    public final void makeTransaction(){
        recieverInfo();
        authenticate();
        takeAmount();
        boolean check = checkAmount();
        while(!check){
            System.out.println("Your balance is smaller than amount you want to transfer!");
            takeAmount();
            check = checkAmount();
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
        double balance = this.db.getBalance(sender.getInstaPayId());
        if(balance < this.amount){
            return false;
        }
        return true;
    }

    public void updateBalance(double amount){
        db.updateBalanceForSender(sender.getInstaPayId(), amount);
    }
}
