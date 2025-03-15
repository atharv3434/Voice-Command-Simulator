import java.util.Scanner;

public class CommandApp {
    private static CommandProcessor commandProcessor = new CommandProcessor();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🎤 Welcome to Voice Command Simulator 🎤");

        while (true) {
            System.out.println("\n1. Enter Command");
            System.out.println("2. View Command History");
            System.out.println("3. Delete Command History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    commandProcessor.processCommand();
                    break;
                case 2:
                    commandProcessor.viewHistory();
                    break;
                case 3:
                    commandProcessor.clearHistory();
                    break;
                case 4:
                    System.out.println("Exiting... Keep using voice commands! 🎙");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
