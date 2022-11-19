package bridge.domain.command;

import static java.util.Arrays.stream;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q"),
    ;

    private static final String NOT_MATCH_COMMAND = "게임 재시도 여부는 R 또는 Q만이 입력 가능합니다.";

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        return stream(values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COMMAND));
    }
}
