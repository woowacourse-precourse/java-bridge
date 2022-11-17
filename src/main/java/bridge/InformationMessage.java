package bridge;

public enum InformationMessage {
    START("다리 건너기 게임을 시작합니다.");

    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
