import java.util.Scanner;

public class BankAccountServices extends Services {
//    private BankAccount mybankAcc;

//    public BankAccountServices(String myID) {
//        this.myID = myID;
//    }
//    public void setMybankAcc(BankAccount mybankAcc){
//        this.mybankAcc = mybankAcc;
//    }
//
//    public BankAccount getMybankAcc(){
//        return this.mybankAcc;
//    }

    private Transaction transaction;

    @Override
    public void transfer() {
        System.out.println("1- Transfer to Bank.");
        System.out.println("2- Transfer to Wallet.");
        System.out.println("3- Transfer to InstaPay Account.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            transaction = new ToBankTransaction(super.getMyAcc(), super.getDB());
            transaction.makeTransaction();
        }else if(choice == 2){
            transaction = new ToWalletTransaction(super.getMyAcc(), super.getDB());
            transaction.makeTransaction();
        }
    }
    
}
