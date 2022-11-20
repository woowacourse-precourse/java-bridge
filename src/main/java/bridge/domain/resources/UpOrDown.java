package bridge.domain.resources;

import bridge.domain.exception.UDIllegalArgumentException;

public class UpOrDown {

    public final static String UP = "U";
    public final static String DOWN = "D";

    private final String inputUD;

    private UpOrDown(String inputUD) {
        this.inputUD = inputUD;
    }

    public static UpOrDown of(String inputUD) {
        validateRorQ(inputUD);
        return new UpOrDown(inputUD);
    }

    private static void validateRorQ(String inputUD) {
        if (isInputUD(inputUD)) {
            throw new UDIllegalArgumentException();
        }
    }

    private static boolean isInputUD(String inputUD) {
        return !inputUD.equals(UP) && !inputUD.equals(DOWN);
    }

    public String getInputUD() {
        return inputUD;
    }
}
