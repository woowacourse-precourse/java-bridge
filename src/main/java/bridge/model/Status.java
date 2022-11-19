package bridge.model;

import java.util.Arrays;

public enum Status {
    SURVIVE("O", true),
    DIE("X", false);

    private final String display;
    private final boolean isSamePosition;

    Status(String display, boolean isSamePosition) {
        this.display = display;
        this.isSamePosition = isSamePosition;
    }

    public static Status findStatus(boolean isSamePosition) {
        return Arrays.stream(Status.values())
                .filter(status -> status.isSamePosition == isSamePosition)
                .findFirst()
                .orElse(null);
    }

}