package bridge.enums;

public enum ReverseCommands {
    U("D"),
    D("U");

    private String reverseCommand;

    ReverseCommands(String reverseCommand) {
        this.reverseCommand = reverseCommand;
    }

    public static String getReverseCommand(ReverseCommands reverseCommands) {
        return reverseCommands.reverseCommand;
    }
}
