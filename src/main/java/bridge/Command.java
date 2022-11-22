package bridge;

public enum Command {
    DOWN("D"), UP("U"), RETRY("R"), QUIT("Q");

    String command;

    Command(String command) {
        this.command = command;
    }

    public String useCommand() {
        return command;
    }
}
