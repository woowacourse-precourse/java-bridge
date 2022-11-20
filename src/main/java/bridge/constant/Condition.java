package bridge.constant;

public enum Condition {
    IN_PROGRESS("현재 진행 중", "O"),
    GOAL("성공", "O"),
    FAILURE("실패", "X");

    private final String detail;
    private final String symbol;

    Condition(String detail, String symbol) {
        this.detail = detail;
        this.symbol = symbol;
    }

    public String getDetail() {
        return detail;
    }

    public String getSymbol() {
        return symbol;
    }
}
