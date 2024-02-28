package users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersReader {
    public static void main(String[] args) {
        usersWriteToJson();
    }

    public static void usersWriteToJson() {
        File jsonFile = new File("files/users.json");

        try (Reader reader = new FileReader("files/users.txt")) {
            List<User> users = new ArrayList<>();

            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String userData = scanner.nextLine();
                String[] userParts = userData.split(" ");

                User user = new User(userParts[0], Integer.parseInt(userParts[1]));
                users.add(user);
            }

            FileWriter writer = new FileWriter(jsonFile);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
