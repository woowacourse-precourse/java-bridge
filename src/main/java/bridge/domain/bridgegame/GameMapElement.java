package bridge.domain.bridgegame;

public enum GameMapElement {
    MOVING_SUCCESS("O"),
    MOVING_FAIL("X"),
    NOT_SELECTED(" ");

    private final String result;

    GameMapElement(String result) {
        this.result = result;
    }

    public static String getMapElement(boolean movingSuccess) {
        if (movingSuccess) {
            return MOVING_SUCCESS.result;
        }
        return MOVING_FAIL.result;
    }

    public static String getMapElement() {
        return NOT_SELECTED.result;
    }
}
