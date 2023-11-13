import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Register extends ManagingSigning {
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
        System.out.println("Enter your Username: ");
        userName = scanner.nextLine();
        //while the password is not complex
        boolean checkPass = true;
        do {
            System.out.println("Enter the desired password:");
            System.out.println("Password should be a mix of lowercase and uppercase , special characters and numbers");
            System.out.println("password should be at least 8 characters");
            password = scanner.nextLine();
            checkPass = !checkingPassComplexity(password);
        }
        while(checkPass);
        System.out.println("Enter your email: ");
        email = scanner.nextLine();
        System.out.println("You want to register with a wallet or with your bank account?: ");
        System.out.println("1-wallet\n2-Bank Account");
        choiceAccount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

       String accID = new String();
        String walletNo= new String();
        String phoneNumber= new String();

        boolean accountExists = true;
        if(choiceAccount ==1)
        {
            System.out.println("Please enter the phone number you use for your wallet");
            walletNo= scanner.nextLine();
            accountExists = validateData(walletNo);

        }
        else if(choiceAccount == 2)
        {
            System.out.println("Please enter you bank account ID to verify:");
            accID= scanner.nextLine();
            accountExists = validateData(accID);
        }
        if(accountExists) // create personal account on instapay
        {
            System.out.println("Enter phone number to verify");
            phoneNumber= scanner.nextLine();
            //send otp
            boolean isVerified = verifyUser(phoneNumber);
            if(isVerified && choiceAccount ==2)
            {
                double balance = 12000.00;

                // need to get real balance from the bankAPI
                // status also should be get from bankAPI
                Services services = new BankAccountServices();
                a= new BankAccount(balance,userName, password, email, Status.DEFAULT, accID, services);
                System.out.println("Account Created successfully\npress 1 to proceed to your profile :)");
            }
            else if(isVerified && choiceAccount ==1)
            {
                double balance = 12000.00;
                // need a better way to handle such as enumeration
                System.out.println("Please enter the name of your wallet provider");
                String provider = scanner.nextLine();
                // need to get real balance from the bankAPI
                // status also should be get from bankAPI
                Services services = new WalletServices();
                 a = new WalletAccount(balance,userName,password,email,Status.DEFAULT,walletNo,provider, services);
                System.out.println("Account Created successfully\npress 1 to proceed to your profile :)");

            }

            else
            {
                System.out.println("Unfortunately, couldn't verify , try again later");
            }
            //should include try and catch to handle
            this.saveToDB(a);
            a.viewAccDetails();
            a.viewServices();
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
    public boolean validateData(String Id){
        BankAuthentication auth = new BankAuthentication();
        auth.setBank(data.getMybank());
        return auth.authenticateProvidedInfo(Id);
    }
    // needs to be interface and the provider is used to know it is which wallet provider
    public boolean ValidateData(String phonenumber , String provider)
    {
         WalletAuthentication auth = new WalletAuthentication();
         auth.getWallet(data.getMyWallet());
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
        //add to db or list
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
