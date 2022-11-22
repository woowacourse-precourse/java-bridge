package bridge.domain;

public enum Result {
    UP_SUCCESS("U", "O"),
    UP_FAIL("U", "X"),
    DOWN_SUCCESS("D", "O"),
    DOWN_FAIL("D", "X");

    private final String moving;
    private final String acceptability;

    Result(String moving, String acceptability) {
        this.moving = moving;
        this.acceptability = acceptability;
    }

    public String getMoving() {
        return moving;
    }

    public String getAcceptability() {
        return acceptability;
    }
}