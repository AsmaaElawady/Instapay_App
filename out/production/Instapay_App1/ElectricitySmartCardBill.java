import java.util.Scanner;

public class ElectricitySmartCardBill extends Bill{
    private String cardNo;
     private double chargeAmount;


     
    public ElectricitySmartCardBill(Account account) {
        super(account);
        //TODO Auto-generated constructor stub
    }
     
    @Override
    public void calculateTotal() {

        Scanner scanner = new Scanner(System.in);
        String cNo;
        double cAmount;
        while (true) {
            System.out.print("Enter Card number:");
            cNo = scanner.next();

            if (cNo.length() < 8) {
                System.out.println("invalid card number, it should be 8 digits.");
                continue;
            }else{
                break;
            }
        }
        while (true) {
            System.out.print("Enter card charge amount(should be more than 15eg.p):");
            cAmount= scanner.nextDouble();

            if (cAmount< 15) {
                System.out.println("invalid amount value, it should be more than 15eg.");
                continue;
            }else{
                break;
            }
        }
        this.cardNo = cNo;
        this.chargeAmount = cAmount;
        // assigning tha amount of the bill class
        billAmount = chargeAmount; 
        
        
    }
    




    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public double getChargeAmount() {
        return chargeAmount;
    }
    public void setPayAmount(double payAmount) {
        this.chargeAmount = payAmount;
    }


    
}
