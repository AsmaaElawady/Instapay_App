import java.util.ArrayList;
public class Bank {
    ArrayList<bankUser> bankUsers = new ArrayList<>();
    public void addBankUser(bankUser b)
    {
        bankUsers.add(b);
    }

    public boolean containsUser(String id)
    {
        for(bankUser b : bankUsers)
        {
            if(b.getID().equals(id)) return true;
        }
        return false;
    }

    public ArrayList<bankUser> getBankUsers(){
        return this.bankUsers;
    }
}
