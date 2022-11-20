package bridge.constant;

public enum GameStatus {
    CONTINUE("계속"), FAIL("실패"), SUCCESS("성공");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
