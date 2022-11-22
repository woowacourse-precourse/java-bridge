package bridge;

public class Command {
    private String command;

    public Command(String command) {
        this.command = checkCommand(command);
    }

    public String getCommand() {
        return command;
    }

    private String checkCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            generateError("[ERROR] 재시도 명령어는 R나 Q여야 합니다.");
        }
        return input;
    }

    private void generateError(String message) {
        throw new IllegalArgumentException(message);
    }
}
