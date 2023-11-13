public abstract class Account {
    private static int counter = 0;
    private double balance; // will get it from the bank/ wallet provider
    private String userName;
    private String password;
    private String email;
    private Status status;
    private String instaPayId;

    public Account(double balance, String userName, String password, String email, Status status) {
        counter++;
        this.balance = balance;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.status = status;
        this.instaPayId = String.valueOf(counter);
    }
    public void viewAccDetails()
    {
        System.out.println("UserName: " + userName);
        System.out.println("Instapay ID: " + instaPayId);
        System.out.println("balance: " + balance);
        System.out.println("status: " + status);

    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Account.counter = counter;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInstaPayId() {
        return instaPayId;
    }

    public void setInstaPayId(String instaPayId) {
        this.instaPayId = instaPayId;
    }
}
