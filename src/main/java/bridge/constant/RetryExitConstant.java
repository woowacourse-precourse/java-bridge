package bridge.constant;

public enum RetryExitConstant {
    RETRY("재시도", "R"),
    EXIT("종료", "Q");


    private String status;
    private String symbol;

    RetryExitConstant(String status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static RetryExitConstant of(String symbol) {
        if (symbol == RETRY.symbol) {
            return RETRY;
        } else if (symbol == EXIT.symbol) {
            return EXIT;
        }
        throw new IllegalArgumentException(ErrorStringConstant.RETRY_OR_EXIT_INPUT_ERROR_MESSAGE.getError());
    }

    public String getSymbol() {
        return symbol;
    }

    public String getStatus() {
        return status;
    }
}
