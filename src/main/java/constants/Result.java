package constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Result {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String status;
    private final boolean value;

    Result(String status, boolean value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public boolean getValue() {
        return value;
    }

    private static final Map<Boolean, String> BY_VALUE =
            Stream.of(values()).collect(Collectors.toMap(Result::getValue, Result::getStatus));

    public static String valueToStatus(boolean value) {
        return BY_VALUE.get(value);
    }
}
