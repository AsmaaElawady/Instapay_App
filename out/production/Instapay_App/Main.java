import java.util.Scanner;


public class Main {
    ManagingSigning m;
    ManageingView mView;
    public void start()
    {
        System.out.println("welcome to Instapay");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("press 1 to register or 2 to login");
            choice = scanner.nextInt();

        }
        while(choice != 1 && choice != 2);
        if(choice == 1)
        {
            m = new Register();
            m.takeUserGeneralData();
        }else if(choice == 2)
        {
            m = new Login();
            m.takeUserGeneralData();
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
        m.start();


    }
}
