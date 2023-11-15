//template method pattern is used here
public abstract class ManagingSigning {
    protected Account a;
    protected bankUser bu;
    protected walletUser wu;
    protected Authentication auth;
    public final Account enter()
    {
        takeUserGeneralData();
        validateData();
        return a;
    }
    public abstract void takeUserGeneralData();
    public  abstract boolean validateData();
}
