package bridge.enums;

public enum OutputMsg {
    MSG_OUTPUT_START_GAME("다리 건너기 게임을 시작합니다.");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
