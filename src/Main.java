import numbers.PhoneNumbersReader;
import users.UsersWorker;
import words.WordsRepeated;

public class Main {
    public static void main(String[] args) {
        PhoneNumbersReader.phoneNumbersPrinter();

        UsersWorker.usersWriteAndReadToJson();

        WordsRepeated.repeats();
    }
}