package bridge.model;

import java.util.Arrays;
import java.util.List;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    public static final List<String> COMMAND_OPTIONS = List.of("R", "Q");
    private final String input;

    GameCommand(String input) {
        this.input = input;
    }

    public static void validateGameCommandInput(String input) {
        if(!COMMAND_OPTIONS.contains(input)){
            throw new IllegalArgumentException("R/Q 중 재시작 여부를 입력해 주세요.");
        }
    }
}
