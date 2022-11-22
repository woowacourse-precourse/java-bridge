package utils;

public enum UpDown {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String command;

    UpDown(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public int getNumber() {
        return number;
    }

    public String getCommand() {
        return command;
    }
}
