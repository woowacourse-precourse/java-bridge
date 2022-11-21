package bridge.domain;

import static bridge.constant.ExceptionMessage.RETRY_COMMAND_EXCEPTION_MESSAGE;

import java.util.Arrays;

public enum GameCommand {
    QUIT("Q"), RETRY("R");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String inputLetter) {
        return Arrays.stream(values())
                .filter(retry -> retry.command.equals(inputLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RETRY_COMMAND_EXCEPTION_MESSAGE));
    }

    public static boolean hasCommand(String inputLetter) {
        return Arrays.stream(values())
                .anyMatch(gameCommand -> gameCommand.command.equals(inputLetter));
    }

}
