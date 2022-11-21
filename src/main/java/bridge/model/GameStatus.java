package bridge.model;

public enum GameStatus {
    PLAY, PENDING, END;

    public static GameStatus getGameStatusOf(GameCommand command) {
        if (command == GameCommand.R) {
            return PLAY;
        }
        return END;
    }

    public boolean isPlay() {
        return this == PLAY;
    }

    public boolean isPending() {
        return this == PENDING;
    }
}
