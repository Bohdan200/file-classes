import numbers.PhoneNumbersReader;
import users.UsersReader;
import words.WordsRepeated;

public class Main {
    public static void main(String[] args) {
        PhoneNumbersReader.phoneNumbersPrinter();

        UsersReader.usersWriteToJson();

        WordsRepeated.repeats();
    }
}