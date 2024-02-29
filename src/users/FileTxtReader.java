package users;

import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTxtReader {
    public static List<User> read(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }

        List<User> users = new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                String userData = scanner.nextLine();
                String[] userParts = userData.split(" ");

                User user = new User(userParts[0], Integer.parseInt(userParts[1]));
                users.add(user);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}