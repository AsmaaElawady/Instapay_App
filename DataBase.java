import java.util.ArrayList;

public class DataBase {
    ArrayList<bankUser> bankUsers = new ArrayList<>();
    
    public DataBase(ArrayList<bankUser> bankUsers){
        System.out.println(bankUsers);
        this.bankUsers = bankUsers;
    }

    // public void addBankUser(bankUser b){
    //     bankUsers.add(b);
    // }

    public void updateBalance(String id, double amount){
        for(bankUser b : bankUsers){
            if(b.getID().equals(id)){
                double balance = b.getBalance();
                b.setBalance(balance+=amount);
                System.out.println(b.getUsername() + " received the amount successfully!");
            }
        }
    }
}
