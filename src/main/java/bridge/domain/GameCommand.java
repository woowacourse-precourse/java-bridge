package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    QUIT("Q"),
    RETRY("R"),
    ;
    private static final String INVALID_COMMAND_MESSAGE = "올바른 명령이 아닙니다. R(재시작)과 Q(종료) 중 하나의 문자만 가능합니다.";

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        return Arrays.stream(values())
            .filter(value -> value.command.equals(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public String getCommand() {
        return command;
    }
}
