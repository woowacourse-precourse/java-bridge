package bridge;

import static bridge.UserInterface.INVALID_EXCEPTION;

import java.util.Arrays;

public enum GameStatus {

    SELECT_RE_TRY("R"),
    QUIT("Q");

    private final String gameStatus;

    GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameStatus validate(String readLine) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.tellCommand().equals(readLine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_EXCEPTION.interact()));
    }

    public boolean tellGameStatus() {
        return this.equals(SELECT_RE_TRY);
    }

    public String tellCommand() {
        return gameStatus;
    }
}
