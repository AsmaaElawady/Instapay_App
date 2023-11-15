import java.util.Scanner;

public class WalletServices extends Services {
    private String walletNo;
    public WalletServices(String walletNo) {
        this.walletNo = walletNo;
    }

    public WalletServices() {}

    @Override
    public void transfer() {
        System.out.println("1- Transfer to Wallet.");
        System.out.println("2- Transfer to InstaPay Account.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1){
            transaction = new ToWalletTransaction(super.getMyAcc(), super.getDB());
            transaction.makeTransaction();
        }else if(choice == 2){
            transaction = new ToInstaPayTransaction(super.getMyAcc(), super.getDB());
            transaction.makeTransaction();
        }
    }
}
