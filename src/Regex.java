import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {


    public final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9a-z._%+-]+@[A-Z a-z 0-9.-]+\\.[A-Z a-z 0-9]{2,6}$";

    public  final String VALID_NUMBER_PHONE_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    public boolean regexEmail(String email) {
        Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean regexNumberPhone(String numberPhone) {
        Pattern pattern = Pattern.compile(VALID_NUMBER_PHONE_REGEX);
        Matcher matcher = pattern.matcher(numberPhone);
        return matcher.matches();
    }
}

