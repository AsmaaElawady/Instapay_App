import java.util.Random;
import java.util.Scanner;

public class ElectricitySmartMeterBill  extends Bill{


    protected String meterNO;
    protected String companyName;
    protected double amount;

    public ElectricitySmartMeterBill(Account account) {
        super(account);
        
    }

    @Override
    public void calculateTotal() {
        Scanner scanner = new Scanner(System.in);

    
        String compName;
        String metNo;
        double amnt;


        while (true) {
            System.out.print("Enter Meter number:");
            metNo = scanner.next();

            if (metNo.length() < 8) {
                System.out.println("invalid meter number, it should be 8 digits.");
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

            this.meterNO = metNo;
            this.companyName = compName;
            this.amount = amnt;
       
            // assigning tha amount of the bill class
            billAmount = amount; 
        
    }
    
}
