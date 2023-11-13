public class dummyData {
    public Bank mybank = new Bank();
    public WalletProvider myWallet = new WalletProvider();

    public dummyData() {
        mybank.addBankUser(new bankUser("marwa", "1", "marwa2003", 12000));
        mybank.addBankUser(new bankUser("esraa", "2", "marwa2003", 12000));
        mybank.addBankUser(new bankUser("salma", "3", "marwa2003", 12000));
        mybank.addBankUser(new bankUser("rawan", "4", "marwa2003", 12000));
        mybank.addBankUser(new bankUser("asmaa", "5", "marwa2003", 12000));
        mybank.addBankUser(new bankUser("osama", "6", "marwa2003", 12000));


        myWallet.addWallet(new walletUser("marwa", "1", 12000));
        myWallet.addWallet(new walletUser("esraa", "2", 12000));
        myWallet.addWallet(new walletUser("salma", "3", 12000));
        myWallet.addWallet(new walletUser("rawan", "4", 12000));
        myWallet.addWallet(new walletUser("asmaa", "5", 12000));
        myWallet.addWallet(new walletUser("osama", "6", 12000));
    }

    public Bank getMybank() {
        return mybank;
    }

    public void setMybank(Bank mybank) {
        this.mybank = mybank;
    }

    public WalletProvider getMyWallet() {
        return myWallet;
    }

    public void setMyWallet(WalletProvider myWallet) {
        this.myWallet = myWallet;
    }

    public boolean checkWallet(String password) {
        return myWallet.containsUser(password);
    }

    public boolean checkBank(String password) {
        return mybank.containsUser(password);
    }
}
