package bridge.enums;

public enum KeyboardCommand {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private String command;

    KeyboardCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
