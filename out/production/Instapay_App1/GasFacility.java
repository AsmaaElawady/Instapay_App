import java.util.Scanner;

public class GasFacility implements Facilities{

    @Override
    public Bill createBill(Account account) {

       
        
        Scanner scanner = new Scanner(System.in);
        int choice;


        System.out.println("Types of services 1- Bill");
        while (true) {
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();


            if (choice != 1 ) {
                System.out.print("invalid choice:");
                continue;
            }else {
                break;
            }
        }

        Bill bill = null;

        switch (choice) {
            case 1:
               bill =  new GasTradBill(account);
               break;
    
            default:
                break;
        }


        return bill;
        

    
    }
    
    
}
