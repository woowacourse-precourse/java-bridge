package bridge.domain;

public enum ClearInfo {
    ClEAR("성공"),
    NOT("실패");

    private final String clearOrNot;

    ClearInfo(String clearOrNot) {
        this.clearOrNot = clearOrNot;
    }

    public String getMessage() {
        return clearOrNot;
    }
}
