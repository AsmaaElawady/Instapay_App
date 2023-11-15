import java.util.ArrayList;
import java.util.Scanner;

public class ToBankTransaction extends Transaction{
    public ToBankTransaction(Account myAcc, DataBase db){
        super.setSender(myAcc);
        super.setDB(db);
    }

    private String recieverBankID;

    public void setReciverBankID(String recieverBankID){
        this.recieverBankID = recieverBankID;
    }

    public String getReciverBankID(){
        return this.recieverBankID;
    }

    @Override
    public void recieverInfo() {
        String id;
        System.out.print("Enter the receiver's bank ID: ");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLine();
        setReciverBankID(id);
    }

    @Override
    public void authenticate() {
        BankAuthentication auth = new BankAuthentication();
        auth.setBank(data.getMybank());
        boolean isAuthenticated = auth.authenticateProvidedInfo(recieverBankID);

        while (!isAuthenticated) {
            System.out.println("No Bank User with this ID!");
            recieverInfo();
            isAuthenticated = auth.authenticateProvidedInfo(recieverBankID);
        }

        System.out.println("Authentication successful!");
    }

    @Override
    public void transfer() {
        db.updateBalanceForBankReceiver(recieverBankID, getAmount());
    }
}
