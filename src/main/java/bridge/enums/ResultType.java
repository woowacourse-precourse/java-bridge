package bridge.enums;

import java.util.Arrays;

import static bridge.utils.ErrorMessage.*;

public enum ResultType {
    NOT_SELECT(" ", 0),
    WRONG("X", 1),
    CORRECT("O", 2);

    private String representation;
    private final int code;

    ResultType(String representation, int code) {
        this.representation = representation;
        this.code = code;
    }

    public static ResultType selectResultTypeByCode(int code) {
        return Arrays.stream(ResultType.values())
                .filter(result -> result.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NUMBER_NOT_OPTIONS));
    }

    public int getCode() {
        return code;
    }
}