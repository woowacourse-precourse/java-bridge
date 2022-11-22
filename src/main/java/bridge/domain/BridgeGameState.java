package bridge.domain;

public enum BridgeGameState {
    START("시작"),
    CONTINUE("진행중"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String type;

    BridgeGameState(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public boolean isBridgeGameContinue() {
        return this == START || this == CONTINUE;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
