package users;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.List;

public class FileJsonReader {
    public static void read(String filePath) {
        try(Reader readerJSON = new FileReader(filePath)) {
            Type itemsListType = new TypeToken<List<User>>() {}.getType();
            List<User> usersFromJson = new Gson().fromJson(readerJSON, itemsListType);

            usersFromJson.forEach(user -> System.out.println(user.getName() + " " + user.getAge()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
