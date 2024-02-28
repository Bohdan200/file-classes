package numbers;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Scanner;
import java.util.regex.Pattern;


public class PhoneNumbersReader {
    public static void main(String[] args) {
        phoneNumbersPrinter();
    }

    public static void phoneNumbersPrinter() {
        Pattern pattern = Pattern.compile(
                "([(][0123456789]{3}[)][ ][0123456789]{3}[\\-][0123456789]{4})" +
                        "|" +
                        "([0123456789]{3}[\\-][0123456789]{3}[\\-][0123456789]{4})");

        try (InputStream fis = new FileInputStream("files/phoneNumbers.txt")) {
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNextLine()) {
                String phoneNumber = scanner.nextLine();

                if (pattern.matcher(phoneNumber.strip()).matches()) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
