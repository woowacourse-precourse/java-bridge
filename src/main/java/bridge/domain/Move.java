package bridge.domain;

import exception.ExceptionMessage;
import java.util.Arrays;

public enum Move {
    UP(1, "U"), DOWN(0, "D");

    private int number;
    private String command;

    Move(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public static String getPositionByNumber(int number) {
        return Arrays.asList(values()).stream()
                .filter(position -> position.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DOES_NOT_EXIST_POSITION_OF_NUMBER))
                .getCommand();
    }

    public static Move findByCommand(String userCommand) {
        return Arrays.stream(Move.values())
                .filter(moving -> userCommand.equals(moving.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DOES_NOT_EXIST_GAME_COMMAND));
    }

    public String getCommand() {
        return this.command;
    }
}
