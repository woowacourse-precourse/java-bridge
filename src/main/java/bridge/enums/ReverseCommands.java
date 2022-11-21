package bridge.enums;

public enum ReverseCommands {
    REVERSE_UP("U", "D"),
    REVERSE_DOWN("D", "U");

    private String command;
    private String reverseCommand;

    ReverseCommands(String command, String reverseCommand) {
        this.command = command;
        this.reverseCommand = reverseCommand;
    }

    public static String getReverseCommand(ReverseCommands reverseCommands) {
        return reverseCommands.reverseCommand;
    }
}
