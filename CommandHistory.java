import java.io.Serializable;

public class CommandHistory implements Serializable {
    private String command;

    public CommandHistory(String command) {
        this.command = command;
    }

    public String getCommand() { return command; }

    @Override
    public String toString() {
        return "🎙 Command: " + command;
    }
}
