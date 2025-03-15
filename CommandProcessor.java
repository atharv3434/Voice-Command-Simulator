import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.*;

public class CommandProcessor {
    private List<String> commandHistory;
    private Scanner sc;

    public CommandProcessor() {
        this.commandHistory = CommandStorage.loadHistory();
        this.sc = new Scanner(System.in);
    }

    public void processCommand() {
        System.out.print("🎤 Enter a command: ");
        String command = sc.nextLine().toLowerCase();
        commandHistory.add(command);
        CommandStorage.saveHistory(commandHistory);

        if (command.startsWith("search ")) {
            String query = command.replace("search ", "").trim();
            searchWeb(query);
        } else if (command.startsWith("open ")) {
            String app = command.replace("open ", "").trim();
            openApplication(app);
        } else if (command.startsWith("remind ")) {
            String reminder = command.replace("remind ", "").trim();
            setReminder(reminder);
        } else if (command.startsWith("play ")) {
            String song = command.replace("play ", "").trim();
            playMusic(song);
        } else {
            System.out.println("❌ Command not recognized!");
        }
    }

    private void searchWeb(String query) {
        System.out.println("🔍 Searching for: " + query);
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com/search?q=" + query.replace(" ", "+")));
        } catch (Exception e) {
            System.out.println("❌ Unable to open web browser.");
        }
    }

    private void openApplication(String app) {
        System.out.println("📂 Opening " + app);
        try {
            if (app.equals("notepad")) {
                new ProcessBuilder("notepad.exe").start();
            } else if (app.equals("calculator")) {
                new ProcessBuilder("calc.exe").start();
            } else {
                System.out.println("❌ Application not recognized.");
            }
        } catch (IOException e) {
            System.out.println("❌ Failed to open application.");
        }
    }

    private void setReminder(String reminder) {
        System.out.println("⏰ Reminder Set: " + reminder);
    }

    private void playMusic(String song) {
        System.out.println("🎵 Playing: " + song);
    }

    public void viewHistory() {
        if (commandHistory.isEmpty()) {
            System.out.println("📄 No command history.");
            return;
        }

        System.out.println("\n📜 Command History:");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ". " + commandHistory.get(i));
        }
    }

    public void clearHistory() {
        commandHistory.clear();
        CommandStorage.saveHistory(commandHistory);
        System.out.println("✅ Command History Cleared!");
    }
}
