package bridge.model;

import java.util.Arrays;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private String input;

    Command(String input) {
        this.input = input;
    }

    public static Command find(String input) {
        return Arrays.stream(values())
                .filter(command -> input.equals(command.input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다. R 또는 Q를 입력해주세요."));
    }
}
