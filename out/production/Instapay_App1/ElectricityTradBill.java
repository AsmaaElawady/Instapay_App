import java.util.Random;
import java.util.Scanner;


public class ElectricityTradBill extends Bill{

    protected String billCode;
    protected String companyName;
    protected double amount;


    public ElectricityTradBill(Account account) {
        super(account);
    }

    @Override
    public void calculateTotal() {
        Scanner scanner = new Scanner(System.in);

    
        String compName;
        String bCode;
        double amnt;


        while (true) {
            System.out.print("Enter Bill code:");
            bCode = scanner.next();

            if (bCode.length() < 8) {
                System.out.println("invalid bill code, it should be 8 digits.");
                continue;
            }else{
                break;
            }
        }
        
            System.out.print("Enter bill Company name:");
            compName = scanner.next();

            
        
            Random rand = new Random();
            amnt = rand.nextInt(851) + 50;

            System.out.println("Your bill amount is:" + amnt);

            this.billCode = bCode;
            this.companyName = compName;
            this.amount = amnt;
       
            // assigning tha amount of the bill class
            billAmount = amount; 
    }
    
}
