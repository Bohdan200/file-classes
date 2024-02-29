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
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

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
