package bridge.domain;

import java.util.Arrays;

public enum GameStatus {
    PLAYING("P", "플레이"),
    CLEAR("C", "성공"),
    DEATH("D", "죽음"),
    RETRY("R", "재도전"),
    QUIT("Q", "실패");

    final String input;
    final String meaning;

    GameStatus(String input, String meaning) {
        this.input = input;
        this.meaning = meaning;
    }

    public static String decideGameResult(GameStatus gameStatus) {
        if (gameStatus == CLEAR || gameStatus == QUIT) {
            return gameStatus.meaning;
        }

        throw new IllegalArgumentException(GameException.INVALID_GAME_RESULT.getMessage());
    }

    public static GameStatus receiveInputAfterGameOver(String input) {
        return Arrays.stream(values())
                .filter(status -> status.input.equals(input))
                .filter(status -> status == RETRY || status == QUIT)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(GameException.INVALID_ASK_RETRY_KEY.getMessage()));
    }
}
