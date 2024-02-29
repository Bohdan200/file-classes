package words;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.*;

public class WordsRepeated {
    public static void main(String[] args) {
        repeats();
    }

    public static void repeats() {
        Map<String, Integer> words = new HashMap<>();

        try (InputStream fis = new FileInputStream("files/words.txt")) {
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String newWord = scanner.next();

                if (!words.containsKey(newWord)) {
                    words.put(newWord, 1);
                } else {
                    int value = words.get(newWord);
                    words.put(newWord, value + 1);
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
            list.sort((a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<String, Integer> entry : list)
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
