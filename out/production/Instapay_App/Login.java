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
        // choose log in with bank account or wallet
        System.out.println("You want to log in with a wallet or with your bank account?: ");
        System.out.println("1-wallet\n2-Bank Account");
        Scanner scanner = new Scanner(System.in);
        int choiceAccount = scanner.nextInt();
        scanner.nextLine();
        if(choiceAccount ==1)
        {
            System.out.println("Please enter the phone number you use for your wallet");
            String walletNo= scanner.nextLine();
            boolean accountExists = validateData(walletNo);
            if(accountExists)
            {
                System.out.println("Please enter your password");
                password = scanner.nextLine();
                boolean passwordCorrect = validateData(password);
                if(passwordCorrect)
                {
                    System.out.println("You have successfully logged in");
                    type = "wallet";
                }
                else
                {
                    System.out.println("Wrong password");
                }
            }
            else
            {
                System.out.println("This wallet does not exist");
            }
        }
        else if(choiceAccount == 2)
        {
            System.out.println("Please enter you bank account ID to verify:");
            String accID = scanner.nextLine();
            boolean accountExists = validateData(accID);
            if(accountExists)
            {
                System.out.println("Please enter your password");
                password = scanner.nextLine();
                boolean passwordCorrect = validateData(password);
                if(passwordCorrect)
                {
                    System.out.println("You have successfully logged in");
                    type = "bank";
                }
                else
                {
                    System.out.println("Wrong password");
                }
            }
            else
            {
                System.out.println("This account does not exist");
            }
        }
    }

    public  boolean validateData(String Id){
        if(type == "wallet")
        {
            return data.checkWallet(Id);
        }
        else
        {
            return data.checkBank(Id);
        }
    }
}
