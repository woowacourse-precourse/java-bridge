package bridge.enums;

public enum RetryCommand {
    RETRY("RETRY", "R"),
    END("END","Q"),
    ;

    private String name;
    private String command;

    RetryCommand(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
