import java.util.Scanner;

// this class algortihm should start with pass the account to the constructor when instiatiat it 
public class ManageingView {
    protected Account userAccount;

    

     public ManageingView(Account userAccount) {
      this.userAccount = userAccount;
   }

   public void viewUserProfile(){
        
        userAccount.viewAccDetails();
     }

     public void startMakeServices(){ //depends on the account type
     int choice;
   
      Scanner scanner = new Scanner(System.in);

      System.out.println("Intsapay Available services is:");
      System.out.print("1-check your balance\n" + "2-pay Facility bill\n"+"3-Money Transaction\n");
      System.out.print("Enter your choice:");
      choice = scanner.nextInt();

     Services services = null;

     if (userAccount instanceof BankAccount) {
         services = new BankAccountServices();
     }else if(userAccount instanceof WalletAccount){
      services = new WalletServices();
     }


      switch (choice) {
         case 1:
            System.out.println("Your Balance : "+userAccount.getBalance());
            break;
         case 2:
            services.payBills(userAccount);
            break;
         case 3:
            services.transfer();
            break;   

         default:
            break;
      }
            
     }

     


     public Account getUserAccount() {
      return userAccount;
   }

   public void setUserAccount(Account userAccount) {
      this.userAccount = userAccount;
   }

  

    
}
