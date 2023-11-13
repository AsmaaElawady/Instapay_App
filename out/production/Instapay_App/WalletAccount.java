public class WalletAccount extends Account{
    private String walletId;
    private String walletProvider;

    public String getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public WalletAccount(double balance, String userName, String password, String email, Status status,String walletId, String provider, Services services) {
        super(balance, userName, password, email, status, services);
        this.walletId = walletId;
        this.walletProvider = provider;
    }
    @Override
    public void viewAccDetails()
    {
        super.viewAccDetails();
        System.out.println("Wallet number : " + this.walletId);
        System.out.println("Wallet Provider : " + this.walletProvider);

    }

    @Override
    public void viewServices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewServices'");
    }
}
