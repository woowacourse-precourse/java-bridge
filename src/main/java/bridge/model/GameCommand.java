package bridge.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String input;

    GameCommand(String input) {
        this.input = input;
    }

    public static void validateGameCommandInput(String input) {
        if (!getCommandInputOptions().contains(input)) {
            throw new IllegalArgumentException("R/Q 중 재시작 여부를 입력해 주세요.");
        }
    }

    private static List<String> getCommandInputOptions() {
        return Arrays.stream(GameCommand.values())
                .map(command -> command.input)
                .collect(Collectors.toList());
    }

}
