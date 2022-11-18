package bridge;

public enum Command {
    UP("1"), DOWN("0"),
    ;

    private String commandNumber;

    Command(String commandNumber) {
        this.commandNumber = commandNumber;
    }
}
