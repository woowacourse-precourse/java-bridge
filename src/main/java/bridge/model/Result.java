package bridge.model;

import java.util.Arrays;

import static bridge.exception.InputExceptionMessage.INPUT_NOT_FIND_EXCEPTION;

public enum Result {
    UP(1, "U"),
    DOWN(0, "D");

    private final int code;
    private final String symbol;

    private Result(int code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public static String getSymbol(int code) {
        return Arrays.stream(Result.values())
                .filter(e -> e.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_FIND_EXCEPTION.message())).symbol;
    }

    public static int getCode(String symbol) {
        return Arrays.stream(Result.values())
                .filter(e -> e.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_NOT_FIND_EXCEPTION.message())).code;
    }
}
