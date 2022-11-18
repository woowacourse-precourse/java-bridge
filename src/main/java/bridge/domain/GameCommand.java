package bridge.domain;

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
                .get();
    }

    public static boolean hasCommand(String inputLetter) {
        return Arrays.stream(values())
                .anyMatch(gameCommand -> gameCommand.command.equals(inputLetter));
    }

}
