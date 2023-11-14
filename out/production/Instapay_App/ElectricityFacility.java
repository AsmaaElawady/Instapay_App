import java.util.Scanner;

public class ElectricityFacility implements Facilities{

    @Override
    public Bill createBill(Account account) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Types of service   1-Smart card 2-Bill 3-Smart meter");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();

        while (true) {
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            if (choice != 1 || choice != 2 || choice != 3) {
                System.out.print("invalid choice:");
                continue;
            }else {
                break;
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
