package users;

import java.util.List;

public class UsersWorker {
    public static void main(String[] args) {
        usersWriteAndReadToJson();
    }

    public static void usersWriteAndReadToJson() {
        List<User> list = FileTxtReader.read("files/users.txt");

        FileToJsonWriter.write("files/users.json", list);

        FileJsonReader.read("files/users.json");
    }
}
