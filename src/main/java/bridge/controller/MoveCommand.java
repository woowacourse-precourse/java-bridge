package bridge.controller;

import java.util.Arrays;

public enum MoveCommand {
    UP ("U", 1),
    DOWN ("D", 0);

    private final String command;
    private final int value;

    MoveCommand(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public int getValue() {
        return value;
    }

    public static String parseValueToCommand(int value) {
        return Arrays.stream(MoveCommand.values())
                .filter(move -> move.getValue() == value)
                .map(move -> move.command)
                .findFirst()
                .orElseThrow();
    }
}
