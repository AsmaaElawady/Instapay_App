import java.util.Scanner;

public abstract class Services {
    private Account myAcc;

    private DataBase db;

    public void setMyAcc(Account myAcc){
        System.out.println(myAcc.getUserName());
        this.myAcc = myAcc;
    }

    public Account getMyAcc(){
        return this.myAcc;
    }

    public void setDB(DataBase db){
        this.db = db;
    }

    public DataBase getDB(){
        return this.db;
    }
    public abstract void transfer();

    public void payBills(Account acc) {

        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Chosse one of these facilites:");
        System.out.println("1- Electricity\n"+"2-Water\n"+"3-Gas");
        int choice;
        choice = scanner.nextInt();

        Facilities factory = null;
        switch (choice) {
            case 1:
                factory = new ElectricityFacility();
                break;
            case 2:
                factory = new WaterFacility();
                break;
            case 3:
                factory = new GasFacility();
                break;    

            default:
                break;
        }
        Bill bill = factory.createBill(acc);
        bill.payBill();
    } ////////////////////////
}
