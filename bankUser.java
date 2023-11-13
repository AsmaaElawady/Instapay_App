// this is for the bank class to have list of bankUsers

public class bankUser {
    private String username;
    private String ID;
    private String password;
    private double balance;

    public bankUser(String username, String ID, String password, double balance) {
        this.username = username;
        this.ID = ID;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
