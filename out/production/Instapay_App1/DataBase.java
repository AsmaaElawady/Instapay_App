import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DataBase {
     ArrayList<bankUser> bankUsers = new ArrayList<>();
    ArrayList<walletUser> walletUsers = new ArrayList<>();
    ArrayList<Account> instaPayAccounts = new ArrayList<>();

    public boolean checkInstaPayAcc(String id){
        for(Account acc: instaPayAccounts){
            if (acc.getInstaPayId().equals(id)){
                System.out.println(acc.getUserName());
                return true;
            }
        }
        return false;
    }

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

    public void updateBalanceForInstaPayAccReceiver(String id, double amount){
        for(Account acc : instaPayAccounts){
            if(acc.getInstaPayId().equals(id)){
                double balance = acc.getBalance();
                acc.setBalance(balance+=amount);
                System.out.println(acc.getUserName() + " received the amount successfully!");
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
        Services walletServices = new WalletServices() ;
        Services bankServices = new WalletServices() ;

        this.addUser(new BankAccount(1300 , "Marwa","maRwa@#23","email", Status.Active ,"1", bankServices));
        this.addUser(new BankAccount(1400 , "Salma","maRwa@#23","email", Status.Active ,"2", bankServices));
        this.addUser(new BankAccount(1500 , "Asmaa","maRwa@#23","email", Status.Active ,"3", bankServices));
        this.addUser(new BankAccount(1600 , "Rawan","maRwa@#23","email", Status.Active ,"4", bankServices));
        this.addUser(new BankAccount(1700 , "Rana","maRwa@#23","email", Status.Active ,"5", bankServices));
        this.addUser(new BankAccount(1800 , "Esraa","maRwa@#23","email", Status.Active ,"6", bankServices));

        this.addUser(new WalletAccount(1300 , "Osama","maRwa@#23","email", Status.Active ,"7","provider", walletServices));
        this.addUser(new WalletAccount(1400 , "Abod","maRwa@#23","email", Status.Active ,"8","provider", walletServices));
        this.addUser(new WalletAccount(1500 , "Ahmad","maRwa@#23","email", Status.Active ,"9","provider", walletServices));
        this.addUser(new WalletAccount(1600 , "Hesham","maRwa@#23","email", Status.Active ,"10","provider", walletServices));
        this.addUser(new WalletAccount(1700 , "Yosra","maRwa@#23","email", Status.Active ,"11","provider", walletServices));
        this.addUser(new WalletAccount(1800 , "Sara","maRwa@#23","email", Status.Active ,"12", "provider",walletServices));

//        this.instaPayAccounts.add(new BankAccount(1300 , "Sara","maRwa@#23","email", Status.Active ,"1", bankServices));
//        this.instaPayAccounts.add(new WalletAccount(1400 , "Marwa","maRwa@#23","email", Status.Active ,"2","provider", walletServices));
//        this.instaPayAccounts.add(new BankAccount(1500 , "Rawan","maRwa@#23","email", Status.Active ,"3", bankServices));
//        this.instaPayAccounts.add(new WalletAccount(1600 , "Salma","maRwa@#23","email", Status.Active ,"4","provider", walletServices));
//        this.instaPayAccounts.add(new BankAccount(1700 , "Asmaa","maRwa@#23","email", Status.Active ,"5", bankServices));
//        this.instaPayAccounts.add(new WalletAccount(1800 , "Rana","maRwa@#23","email", Status.Active ,"6", "provider",walletServices));
    }

}
