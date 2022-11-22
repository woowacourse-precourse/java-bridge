package bridge.enums;

public enum Commands {
    UP(1, "U"),
    DOWN(0, "D"),
    RETRY(-1, "R"),
    QUIT(-1, "Q");

    private int bridgeNumber;
    private String command;


    Commands(int bridgeNumber, String command) {
        this.bridgeNumber = bridgeNumber;
        this.command = command;
    }

    public static String getCommand(Commands commands) {
        return commands.command;
    }

    public static Commands valueOf(int bridgeNumber) {
        for (Commands commands : Commands.values()) {
            if (commands.bridgeNumber == bridgeNumber) {
                return commands;
            }
        }
        return null;
    }
}
