package bridge;

public enum GameStatus {
    CONTINUE, FAIL, SUCCESS;

    public boolean isContinue() {
        return this == CONTINUE;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public boolean isSUCCESS() {
        return this == SUCCESS;
    }
}
