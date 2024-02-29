package users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileToJsonWriter {
    public static void write(String filePath, List<User> users) {
        File jsonFile = new File(filePath);
        if (!jsonFile.exists()) {
            jsonFile.getParentFile().mkdirs();
        }

        try(FileWriter writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
