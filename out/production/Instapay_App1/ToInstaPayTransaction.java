import java.util.Scanner;

public class ToInstaPayTransaction extends Transaction{

    private String instaPayReceiverID;

    public void setInstaPayReceiverID(String instaPayReceiverID){
        this.instaPayReceiverID = instaPayReceiverID;
    }

    public String getInstaPayReceiverID(){
        return  this.instaPayReceiverID;
    }

    public ToInstaPayTransaction(Account myAcc, DataBase db){
        super.setSender(myAcc);
        super.setDB(db);
    }

    @Override
    public void recieverInfo() {
        String id;
        System.out.print("Enter the receiver's InstaPay ID: ");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLine();
        setInstaPayReceiverID(id);
    }

    @Override
    public void authenticate() {
        boolean isAuthenticated = db.checkInstaPayAcc(instaPayReceiverID);

        while (!isAuthenticated) {
            System.out.println("No InstaPay account with this ID!");
            recieverInfo();
            isAuthenticated = db.checkInstaPayAcc(instaPayReceiverID);
        }

        System.out.println("Authentication successful!");
    }

    @Override
    public void transfer() {
        db.updateBalanceForInstaPayAccReceiver(instaPayReceiverID, getAmount());

    }
}
