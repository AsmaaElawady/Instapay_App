//template method pattern is used here
public abstract class ManagingSigning {
    protected Account a;
    protected Authentication auth;
    public final Account enter()
    {
        String id= new String();
        takeUserGeneralData();
        validateData(id);
        return a;
    }
    public abstract void takeUserGeneralData();
    public  abstract boolean validateData(String Id);
}
