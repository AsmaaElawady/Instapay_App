import java.util.Scanner;


public class Main {
    ManagingSigning m;

    public  Account start() {
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
        }
        Account a =  m.enter();

        if(a!= null)
        {
            System.out.println(a.getUserName() + " "+ a.getBalance());
            return a;
        }
        System.exit(0);
        return null;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Account acc =  m.start();

        System.out.println("\n");

        ManageingView mView = new ManageingView(acc);
        while (true) {
            mView.startMakeServices();

            Scanner scanner = new Scanner(System.in);
            int choice;

            System.out.println("To continue make services enter 1 to exist enter 2:");
            choice = scanner.nextInt();
            if (choice == 1) {
                continue;
            }else{
                break;
            }
        }
        
    }
}
