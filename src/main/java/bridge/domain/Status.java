package bridge.domain;

public enum Status {
    PROCEEDING("게임 진행 중"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public boolean isProceeding() {
        return this == PROCEEDING;
    }

    public String getMessage() {
        return this.message;
    }
}
