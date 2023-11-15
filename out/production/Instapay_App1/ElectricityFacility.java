import java.util.Scanner;

public class ElectricityFacility implements Facilities{

    @Override
    public Bill createBill(Account account) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Types of service:\n" + "1-Smart card\n" + "2-Bill\n" + "3-Smart meter\n");

        

        while (true) {
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                break;
            }else {
                System.out.print("invalid choice:");
                continue;
            }
        }

        Bill bill = null;
        switch (choice) {
            case 1:
               bill =  new ElectricitySmartCardBill(account);
               break;
        
            case 2:
                bill = new ElectricityTradBill(account);
                break;

            case 3:
                bill = new ElectricitySmartMeterBill(account);
                break;

            default:
                break;
        }


        return bill;
        
    }

    
}
