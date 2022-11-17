package bridge;

public enum MoveCommand {
    UP("U"),
    DOWN("D");

    private final String command;

    MoveCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }


    public static MoveCommand setCommand(int number) {
        if (number == 1) {
            return MoveCommand.UP;
        }
        return MoveCommand.DOWN;
    }
}
