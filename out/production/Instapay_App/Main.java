import java.util.Scanner;


public class Main {

    ManagingSigning m;
    ManageingView mView;

    public  Account start()
    {
        System.out.println("welcome to Instapay");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("press 1 to register or 2 to login :");
            choice = scanner.nextInt();

        }
        while(choice != 1 && choice != 2);
        if(choice == 1)
        {
            m = new Register();
        }else if(choice == 2)
        {
            m = new Login();
            m.takeUserGeneralData();
        }
        Account a =  m.enter();
        System.out.println(a.getClass());
        return a;

        
    }
    public static void main(String[] args) {

        

        Main m = new Main();
        Account acc =  m.start();
        // something like this fo the bill 
        // Account account = new BankAccount(1000.0); // Assume BankAccount is a subclass of Account
        Facilities factory = new ElectricityFacility();
        Bill bill = factory.createBill(acc);
        bill.payBill();


    }
}
