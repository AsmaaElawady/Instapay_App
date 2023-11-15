import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// need to get real balance from provider or bank
// need to check phone number and email regex
// need to handle validation through the interface

public class Register extends ManagingSigning {
    public DataBase db = new DataBase();
    Services services;

    private String userName;
    private String password;
    private String email;
    private int choiceAccount;
    private String ID;

    private dummyData data = new dummyData();
    //uses regex to check whether password is complex or not
    boolean checkingPassComplexity(String pass)
    {
        if(pass.length()<8)return false;
        else
        {
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pass);
            return matcher.matches();
        }
    }
    @Override
    public void takeUserGeneralData() {
        System.out.println("Please enter the following information: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Username: ");
        userName = scanner.nextLine();
        //while the password is not complex
        boolean checkPass = true;
        do {
            
            System.out.println("Password should be a mix of lowercase and uppercase , special characters and numbers");
            System.out.println("password should be at least 8 characters");
            System.out.print("Enter the desired password:");
            password = scanner.nextLine();
            checkPass = !checkingPassComplexity(password);
        }
        while(checkPass);
        System.out.print("Enter your email: ");
        email = scanner.nextLine();
        System.out.println("You want to register with a wallet or with your bank account?: ");
        System.out.print("1-wallet\n2-Bank Account :");
        choiceAccount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

       String accID = new String();
        String walletNo= new String();
        String phoneNumber= new String();

        boolean accountExists = true;
        if(choiceAccount ==1)
        {
            System.out.print("Please enter the phone number you use for your wallet:");
            walletNo= scanner.nextLine();
            accountExists = validateData(walletNo,"stc");

        }
        else if(choiceAccount == 2)
        {

            System.out.println("Please enter you bank account ID to verify:");
            ID= scanner.nextLine();
            accountExists = validateData();
        }
        if(accountExists) // create personal account on instapay
        {
            System.out.print("Enter phone number to verify:");
            phoneNumber= scanner.nextLine();
            //send otp
            boolean isVerified = verifyUser(phoneNumber);
            if(isVerified && choiceAccount ==2)
            {
               double balance = bu.getBalance();
               services = new BankAccountServices();
                a= new BankAccount(balance,userName, password, email, Status.DEFAULT, accID, services);
                services.setMyAcc(a);
                System.out.println("Account Created successfully\npress 1 to proceed to your profile :)");
            }
            else if(isVerified && choiceAccount ==1)
            {
                double balance = wu.getBalance();
                System.out.println("Please enter the name of your wallet provider");
                String provider = scanner.nextLine();
                services = new WalletServices(walletNo);
                 a = new WalletAccount(balance,userName,password,email,Status.DEFAULT,walletNo,provider, services);
                services.setMyAcc(a);
                System.out.println("Account Created successfully\npress 1 to proceed to your profile :)");

            }

            else
            {
                System.out.println("Unfortunately, couldn't verify , try again later");
            }
            //should include try and catch to handle
            this.saveToDB(a);
            a.viewAccDetails();
            
            // while(true){
            //     a.viewServices();
            // }
        }
        else System.out.println("Unfortunately, this account does not exist, please contact your bank for further information");
    }

    // it is supposed to check if the user exists or not
    // it should take object of authentication
    // if it is a bank account it instantiate it to bank-api
    // if it is a wallet account it instantiate it to wallet-provider

    //// i don't know how to handle the idea of validating when it is bank and when it is wallet
    @Override
    // problem here of not auth as authentication
    public boolean validateData(){
        BankAuthentication auth = new BankAuthentication();
        auth.setBank(data.getMybank());

        bu = data.getBankUserDetails(Integer.parseInt(this.ID));
        return auth.authenticateProvidedInfo(this.ID);
    }

    // needs to be interface and the provider is used to know it is which wallet provider
    public boolean validateData(String phonenumber , String provider)
    {
         WalletAuthentication auth = new WalletAuthentication();
         auth.setWallet(data.getMyWallet());

          wu = data.getWalletUserDetails(Integer.parseInt(phonenumber));

        return  auth.authenticateProvidedInfo(phonenumber);
    }

    private boolean verifyUser(String phoneNumber)
    {
        Scanner sc = new Scanner(System.in);
        verification v = new verification();
        String OTP = v.DummySendOTP(phoneNumber);
        System.out.println(OTP);
        System.out.println("We've just sent you The OTP, Please enter it: ");
        String input;
        input = sc.nextLine();

        return input.equals(OTP); // until we create verification class and handle OTP
    }
    private void saveToDB(Account account)
    {

//        DataBase db = new DataBase();
        db.addUser(account);
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChoiceAccount() {
        return choiceAccount;
    }

    public void setChoiceAccount(int choiceAccount) {
        this.choiceAccount = choiceAccount;
    }
}
