package bridge;

public enum GameStatus {
    CONTINUE, DIE, SUCCESS;

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
