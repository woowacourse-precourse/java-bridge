package bridge.constants;

public enum Command {
    UP(0, "U"),
    DOWN(1, "D"),
    RE_START(2, "R"),
    END(3, "Q");

    private final int sequence;
    private final String command;

    Command(int sequence, String command) {
        this.sequence = sequence;
        this.command = command;
    }

    public String relevantCommand() {
        return command;
    }
}