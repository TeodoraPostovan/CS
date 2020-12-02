import javax.mail.MessagingException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static boolean isEmail(String email){

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    private static String generateCode() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws MessagingException {
        Scanner input = new Scanner(System.in);
        String email;
        char[] password;
        while (true){
            System.out.println("Enter email:");
            email = input.nextLine();
            if (!isEmail(email)) {
                System.out.println("Invalid email");
                continue;
            }
            System.out.println("Enter password:");
            password = System.console().readPassword();
            break;
        }
        final String validationCode = generateCode();
        SendEmail sendEmail = new SendEmail();
        sendEmail.sendEmailCode(validationCode, email);

        System.out.println("Enter validation code: ");

        while(true){
            String code = input.nextLine();
            if(code.equals(validationCode)){
                System.out.println("------------------------\n");
                System.out.println("Email validated");
                System.out.println("------------------------\n");
                break;
            }else{
                System.out.println("Incorrect code\nTry again");
                continue;
            }
        }

    }
}
