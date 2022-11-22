package bridge.view.constants;

public enum MovingMapDisplay {

    SUCCESS("O"), FAIL("X"),
    NOTHING(" ")
    ;

    private final String display;

    MovingMapDisplay(String display) {
        this.display = display;
    }

    public static String convertMovingToDisplay(boolean isSameStepMoving, boolean isFailedMoving) {
        if (isSameStepMoving) {
            return convertResultToDisplay(isFailedMoving);
        }
        return NOTHING.getDisplay();
    }

    private String getDisplay() {
        return display;
    }

    private static String convertResultToDisplay(boolean isFailedMoving) {
        if (isFailedMoving) {
            return FAIL.getDisplay();
        }
        return SUCCESS.getDisplay();
    }
}
