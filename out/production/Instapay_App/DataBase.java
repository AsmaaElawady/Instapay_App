import java.util.ArrayList;

public class DataBase {
     ArrayList<bankUser> bankUsers = new ArrayList<>();
    ArrayList<walletUser> walletUsers = new ArrayList<>();
    ArrayList<Account> instaPayAccounts = new ArrayList<>();

    public void addBankUsers(ArrayList<bankUser> bankUsers){
         this.bankUsers = bankUsers;
    }

    public void addWalletUsers(ArrayList<walletUser> walletUsers){
        this.walletUsers = walletUsers;
    }

     public void updateBalanceForBankReceiver(String id, double amount){
         for(bankUser b : bankUsers){
             if(b.getID().equals(id)){
                 double balance = b.getBalance();
                 b.setBalance(balance+=amount);
                 System.out.println(b.getUsername() + " received the amount successfully!");
             }
         }
     }

     public void updateBalanceForWalletReceiver(String walletNo, double amount){
         for(walletUser w : walletUsers){
             if(w.getPhoneNumber().equals(walletNo)){
                 double balance = w.getBalance();
                 w.setBalance(balance+=amount);
                 System.out.println(w.getUserName() + " received the amount successfully!");
             }
         }
     }

    public void updateBalanceForSender(String id, double amount){
        for(Account acc : instaPayAccounts){
            if(acc.getInstaPayId().equals(id)){
                double balance = acc.getBalance();
                acc.setBalance(balance-=amount);
                System.out.println(acc.getUserName() + " your balance now: " + acc.getBalance());
            }
        }
    }

     public double getBalance(String id){
         for(Account acc : instaPayAccounts) {
             if (acc.getInstaPayId().equals(id)) {
                 return acc.getBalance();
             }
         }
         return -1;
     }

    ArrayList<Login> users = new ArrayList<>();
    public void addUser(Login l)
    {
        users.add(l);
    }
    public boolean containsUser(String id)
    {
        for(Login l : users)
        {
            if(l.getPassword().equals(id)) return true;
        }
        return false;
    }

    public  void addUser(Account a)
    {
        instaPayAccounts.add(a);
    }

}
