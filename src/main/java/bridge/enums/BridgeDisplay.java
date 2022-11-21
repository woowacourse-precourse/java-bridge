package bridge.enums;

import java.util.Arrays;

public enum BridgeDisplay {
    O(true, "성공"),
    X(false, "실패");

    private boolean bool;
    private String message;

    BridgeDisplay(boolean bool, String message) {
        this.bool = bool;
        this.message = message;
    }

    public boolean isBool() {
        return bool;
    }

    public String getMessage() {return message;}

    public static String getMessage(Boolean bool) {
        return Arrays.stream(BridgeDisplay.values())
                .filter(display -> display.isBool() == bool)
                .findAny()
                .get().getMessage();
    }

    public static String getName(boolean bool) {
        return Arrays.stream(BridgeDisplay.values())
                .filter(display -> display.isBool() == bool)
                .findAny()
                .get().name();
    }


}
