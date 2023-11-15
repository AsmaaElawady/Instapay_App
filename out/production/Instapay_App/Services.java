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
    public void payBills() {} ////////////////////////
}
