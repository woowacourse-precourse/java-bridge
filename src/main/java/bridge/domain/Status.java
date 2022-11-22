package bridge.domain;

import java.util.Arrays;

public enum Status {
    SUCCESS(true, "성공"),
    FAIL(false, "실패");

    private final boolean check;
    private final String message;

    Status(boolean check, String message) {
        this.check = check;
        this.message = message;
    }

    public static String convertCheckToMessage(boolean check) {
        return Arrays.stream(Status.values())
                .filter(status -> status.check == check)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException())
                .message;
    }
}
