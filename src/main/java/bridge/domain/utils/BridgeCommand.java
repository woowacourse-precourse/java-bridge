package bridge.domain.utils;

public enum BridgeCommand {
    DOWN(0, "D"),
    UP(1, "U"),
    NOTING(2, " ");

    private int randomNumber;
    private String command;

    BridgeCommand(int randomNumber, String command) {
        this.randomNumber = randomNumber;
        this.command = command;
    }

    public static String convertRandomNumberToString(int randomNumber) {
        if (randomNumber == DOWN.randomNumber)
            return DOWN.command;
        if (randomNumber == UP.randomNumber)
            return UP.command;
        return NOTING.command;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public String getCommand() {
        return command;
    }
}
