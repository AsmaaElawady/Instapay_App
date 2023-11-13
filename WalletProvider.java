import java.util.ArrayList;

public class WalletProvider {
    ArrayList<walletUser> walletUsers = new ArrayList<>();
    public void addWallet(walletUser w)
    {
        walletUsers.add(w);
    }
    public boolean containsUser(String id)
    {
        for(walletUser w : walletUsers)
        {
            if(w.getPhoneNumber().equals(id)) return true;
        }
        return false;
    }
}
