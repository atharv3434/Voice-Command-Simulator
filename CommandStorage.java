import java.io.*;
import java.util.*;

public class CommandStorage {
    private static final String FILE_PATH = "commands.txt";

    public static void saveHistory(List<String> commandHistory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(commandHistory);
        } catch (IOException e) {
            System.out.println("❌ Error saving command history.");
        }
    }

    public static List<String> loadHistory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
