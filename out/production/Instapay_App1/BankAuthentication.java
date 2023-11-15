public class BankAuthentication implements Authentication{
    Bank b = new Bank();
    
    @Override
    public boolean authenticateProvidedInfo(String ID) {
        // it should contact the bank to check whether this user exists or not
        // we will do this through dummy bank class
        return b.containsUser(ID);
    }

    public void setBank(Bank b){
        this.b = b;
    }
}
