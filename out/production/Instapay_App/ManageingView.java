

public class ManageingView {
    protected Account userAccount;

     public void viewUserProfile(Account userAcc){
        this.userAccount = userAcc;
        userAccount.viewAccDetails();
     }

     public void viewAvailableServices(Account userAcc){ //depends on the account type
            this.userAccount = userAcc;
            userAccount.viewServices();
     }


     public Account getUserAccount() {
      return userAccount;
   }

   public void setUserAccount(Account userAccount) {
      this.userAccount = userAccount;
   }

  
    
}
