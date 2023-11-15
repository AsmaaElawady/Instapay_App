import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DataBase {


    // public void updateBalance(String id, double amount){
    //     for(bankUser b : bankUsers){
    //         if(b.getID().equals(id)){
    //             double balance = b.getBalance();
    //             b.setBalance(balance+=amount);
    //             System.out.println(b.getUsername() + " received the amount successfully!");
    //         }
    //     }
    // }

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
    ArrayList<Account> instaPayAccounts = new ArrayList<>();


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
