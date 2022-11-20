package bridge.domain;

public enum BridgeCrossingStatus {
    SUCCESS("성공"),
    PROGRESS("진행 중"),
    FAIL("실패");

    private final String status;

    BridgeCrossingStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
