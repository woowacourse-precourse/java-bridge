package bridge.domain;

import java.util.Arrays;

public enum GameStatus {
    PLAYING("P"),
    CLEAR("C"),
    FAIL("F"),
    RETRY("R"),
    QUIT("Q");

    final String input;

    GameStatus(String input) {
        this.input = input;
    }

    public static GameStatus receiveInputAfterGameOver(String input) {
        return Arrays.stream(values())
                .filter(status -> status.input.equals(input))
                .filter(status -> status == RETRY || status == QUIT)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }
}
