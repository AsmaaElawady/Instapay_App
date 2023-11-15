import java.util.Scanner;

public class BankAccount extends Account{

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    private String accountID;
    public BankAccount(double balance, String userName, String password, String email, Status status, String accountID, Services services) {
        super(balance, userName, password, email, status, services);
        this.accountID =accountID;
    }

    @Override
    public void viewAccDetails()
    {
        super.viewAccDetails();
        System.out.println("Bank Account ID: " + accountID);
    }
    public void viewServices(){
        System.out.println("Services: ");
        System.out.println("1- Make Transaction.");
        System.out.println("2- Check Balance.");
        System.out.println("3- Pay Bils.");
        System.out.print("Choose Service: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            this.getServices().transfer();
        }else if(choice == 2){
            System.out.println("Your Balance: " + super.getBalance());
        }
    }

    


}