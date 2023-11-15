import javax.xml.crypto.Data;
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
    public Account getAccount(String usname)
    {
        for(Account a : instaPayAccounts)
        {
            if(a.getUserName().equals(usname)) {
                return a;
            }
        }
        return null;
    }
    public boolean foundUSname(String username)
    {
        for(Account a : instaPayAccounts)
        {
            if(a.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public String getAccPass(String userName)
    {
        for(Account a : instaPayAccounts)
        {
            if(a.getUserName().equals(userName)) {
                return a.getPassword();
            }
        }
        return null;
    }


    public DataBase()
    {
         Services s = new WalletServices() ;

        this.addUser(new BankAccount(1300 , "Marwa","maRwa@#23","email", Status.Active ,"1", s));
        this.addUser(new BankAccount(1400 , "Marwa","maRwa@#23","email", Status.Active ,"2", s));
        this.addUser(new BankAccount(1500 , "Marwa","maRwa@#23","email", Status.Active ,"3", s));
        this.addUser(new BankAccount(1600 , "Marwa","maRwa@#23","email", Status.Active ,"4", s));
        this.addUser(new BankAccount(1700 , "Marwa","maRwa@#23","email", Status.Active ,"5", s));
        this.addUser(new BankAccount(1800 , "Marwa","maRwa@#23","email", Status.Active ,"6", s));

        this.addUser(new WalletAccount(1300 , "Marwa","maRwa@#23","email", Status.Active ,"1","provider", s));
        this.addUser(new WalletAccount(1400 , "Marwa","maRwa@#23","email", Status.Active ,"2","provider", s));
        this.addUser(new WalletAccount(1500 , "Marwa","maRwa@#23","email", Status.Active ,"3","provider", s));
        this.addUser(new WalletAccount(1600 , "Marwa","maRwa@#23","email", Status.Active ,"4","provider", s));
        this.addUser(new WalletAccount(1700 , "Marwa","maRwa@#23","email", Status.Active ,"5","provider", s));
        this.addUser(new WalletAccount(1800 , "Marwa","maRwa@#23","email", Status.Active ,"6", "provider",s));


    }

}
