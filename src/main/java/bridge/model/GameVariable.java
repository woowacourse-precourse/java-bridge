package bridge.model;

public class GameVariable {
    private final int numberOfAttempts1;
    private final boolean gameSuccess1;

    private GameVariable(int numberOfAttempts, boolean gameSuccess) {
        numberOfAttempts1 = numberOfAttempts;
        gameSuccess1 = gameSuccess;
    }

    public static GameVariable byInitialValue() {
        return new GameVariable(0, false);
    }
}
