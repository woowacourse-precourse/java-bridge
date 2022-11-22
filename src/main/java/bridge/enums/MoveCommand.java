package bridge.enums;

public enum MoveCommand {
    UP("UP", "U"),
    DOWN("DOWN","D"),
    ;

    private String name;
    private String command;

    MoveCommand(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
