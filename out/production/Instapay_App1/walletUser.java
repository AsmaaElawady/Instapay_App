public class walletUser {
    public walletUser(String userName, String phoneNumber, double balance) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    private String userName;
    private String phoneNumber;
    private double balance;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
