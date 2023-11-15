import java.util.Scanner;

public class Login extends ManagingSigning{
    private String userName;
    private String password;
    private String type;


    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


    private dummyData data = new dummyData();

    @Override
    public void takeUserGeneralData() {
          Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        userName =  scanner.nextLine();
        System.out.println("Enter your password: ");
        password =  scanner.nextLine();
        if(validateData())
        {
            System.out.println("welcome to instapay");
        }
        else
        {
            System.out.println("Sorry this account doesn't exist, try again later");
        }

    }

    public boolean validateData()
    {
        DataBase db = new DataBase();
        if(db.foundUSname(this.userName))
        {
            if(password.equals(db.getAccPass(userName))) {
                a = db.getAccount(userName);

                return true;
            }

        }
        return false;
    }
}
