public class WalletAuthentication implements Authentication {

    WalletProvider w = new WalletProvider();
    @Override
    public boolean authenticateProvidedInfo(String ID) {
        return   w.containsUser(ID);
    }
    public void  setWallet(WalletProvider w)
    {
        this.w = w;
    }
}
