package bridge.domain;

public enum Command {
    U(1),
    D(0);

    private int index;

    Command(int index) {
        this.index = index;
    }

    public static String getCommand(int index) {
        for (Command command : Command.values()) {
            if (command.index == index) {
                return command.name();
            }
        }
        return null;
    }
}
