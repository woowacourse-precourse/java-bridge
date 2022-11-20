package bridge.constant;

import java.util.Arrays;

public enum GameOption {
    RESTART("R"),
    QUIT("Q");

    private String message;

    GameOption(String message) {
        this.message = message;
    }

    public static GameOption getGameOptionByMessage(String message) {
        return Arrays.stream(values())
                .filter(value -> isGameOptionEqual(message, value))
                .findFirst()
                .orElse(null);
    }

    private static Boolean isGameOptionEqual(String message, GameOption gameOption) {
        String gameOptionMessage = gameOption.message;
        return message.equals(gameOptionMessage);
    }
}
