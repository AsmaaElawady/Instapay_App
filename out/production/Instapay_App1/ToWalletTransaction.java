import java.util.Scanner;

public class ToWalletTransaction extends Transaction{
    public ToWalletTransaction(Account myAcc, DataBase db){
        super.setSender(myAcc);
        super.setDB(db);
    }

    private String receiverWalletNo;

    public void setReceiverWalletNo(String receiverWalletNo){
        this.receiverWalletNo = receiverWalletNo;
    }

    public String getReceiverWalletNo(){
        return this.receiverWalletNo;
    }

    @Override
    public void recieverInfo() {
        String walletNo;
        System.out.print("Enter the receiver's wallet number: ");
        Scanner scanner = new Scanner(System.in);
        walletNo = scanner.nextLine();
        setReceiverWalletNo(walletNo);
    }

    @Override
    public void authenticate() {
        WalletAuthentication auth = new WalletAuthentication();
        auth.setWallet(data.getMyWallet());
        boolean isAuthenticated = auth.authenticateProvidedInfo(receiverWalletNo);

        while (!isAuthenticated) {
            System.out.println("No Wallet user with this number!");
            recieverInfo();
            isAuthenticated = auth.authenticateProvidedInfo(receiverWalletNo);
        }

        System.out.println("Authentication successful!");
    }

    @Override
    public void transfer() {
        db.updateBalanceForWalletReceiver(receiverWalletNo, getAmount());
    }
}
