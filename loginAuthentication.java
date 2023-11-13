public class loginAuthentication implements Authentication {
    DataBase db = new DataBase();
    @Override
    public boolean authenticateProvidedInfo(String ID) {
        return db.containsUser(ID);
    }
    public void retriveFromDB(Authentication a) {
        this.db = (DataBase) a;
    }
}
