package bridge.model;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String input;


    GameCommand(String input) {
        this.input = input;
    }


    public static GameCommand from(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(command -> command.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("R/Q 중 재시작 여부를 입력해 주세요."));
    }

    public static boolean selectedRetry(GameCommand command) {
        return command == GameCommand.RETRY;
    }


}
