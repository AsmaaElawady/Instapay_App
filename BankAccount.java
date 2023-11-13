public class BankAccount extends Account{

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    private String accountID;
    public BankAccount(double balance, String userName, String password, String email, Status status, String accountID) {
        super(balance, userName, password, email, status);
        this.accountID =accountID;
    }
    @Override
    public void viewAccDetails()
    {
       super.viewAccDetails();
        System.out.println("Bank Account ID: " + accountID);

    }
}
