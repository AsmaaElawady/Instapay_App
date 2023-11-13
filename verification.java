// this class is to send OTP to the user's phone number upon register
import java.util.Random;

public class verification {
    private String OTP;
    Random random = new Random();
    int randomNumber = 100000 + random.nextInt(900000);

    public String getOTP() {
        return OTP;
    }

    public void setOTP() {

        this.OTP = OTP;
    }
    public String generateOTP()
    {
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000);
        OTP = String.valueOf(randomNumber);
        return OTP;
    }
    public String DummySendOTP(String phoneNUm)
    {
        // it is supposed to send the generated OTP to the phone number
        // we will make it appear on the screen instead
        return generateOTP();
    }
}
