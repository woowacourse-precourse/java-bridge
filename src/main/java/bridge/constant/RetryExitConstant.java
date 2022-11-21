package bridge.constant;

import java.util.Objects;

public enum RetryExitConstant {
    RETRY("재시도", "R"),
    EXIT("종료", "Q");


    private final String status;
    private final String symbol;

    RetryExitConstant(String status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static RetryExitConstant of(String symbol) {
        if (Objects.equals(symbol, RETRY.symbol)) {
            return RETRY;
        } else if (Objects.equals(symbol, EXIT.symbol)) {
            return EXIT;
        }
        throw new IllegalArgumentException(ErrorStringConstant.RETRY_OR_EXIT_INPUT_ERROR_MESSAGE.getError());
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean retry() {
        if (symbol == RETRY.symbol) {
            return true;
        }
        return false;
    }
}
