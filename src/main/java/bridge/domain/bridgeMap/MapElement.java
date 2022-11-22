package bridge.domain.bridgeMap;

public enum MapElement {
    MOVING_SUCCESS("O"),
    MOVING_FAIL("X"),
    NOT_SELECTED(" ");

    private final String result;

    MapElement(String result) {
        this.result = result;
    }

    public static MapElement getMapElement(boolean movingSuccess) {
        if (movingSuccess) {
            return MOVING_SUCCESS;
        }
        return MOVING_FAIL;
    }

    public static MapElement getMapElement() {
        return NOT_SELECTED;
    }

    @Override
    public String toString() {
        return result;
    }
}
