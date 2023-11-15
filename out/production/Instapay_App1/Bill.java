import java.util.Scanner;

public abstract  class Bill {
    protected double billAmount;
    protected Account account;


    public Bill(Account account) {
        this.account = account;
    }
    public abstract void calculateTotal();

    public void payBill(){
        calculateTotal();
        String choice;
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Do you want to process to payment?(yes/no):");
        choice = scanner.next();

        if (choice.charAt(0) == 'y' || choice.charAt(0)=='Y') {
            account.withdraw(billAmount);
        
        }
        
    }

    //setters and getters 
    public double getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(double amount) {
        this.billAmount = amount;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    
} 
