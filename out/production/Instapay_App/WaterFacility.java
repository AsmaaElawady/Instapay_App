import java.util.Scanner;

public class WaterFacility  implements Facilities{

    

    @Override
    public Bill createBill(Account account) {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Types of service   1- Smart card 2- Bill");
        while (true) {
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            if (choice != 1 || choice != 2) {
                System.out.print("invalid choice:");
                continue;
            }else {
                break;
            }
        }

        Bill bill = null;
        switch (choice) {
            case 1:
               bill =  new WaterSmartCardBill(account);
               break;
        
             case 2:
                bill = new WaterTradBill(account);
                break;
                

            default:
                break;
        }


        return bill;
        

    
        
    }
    
}
