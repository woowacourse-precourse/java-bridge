package bridge.domain;

public enum MovingResult {
    SUCCESS("O"),
    FAIL("X"),
    NOTTING(" ");

    private final String result;

    MovingResult(String result) {
        this.result = result;
    }

    public static MovingResult of(boolean isMove) {
        if (isMove) {
            return SUCCESS;
        }
        return FAIL;
    }

    public static MovingResult of(
            Direction direction,
            Direction selectDirection,
            MovingResult movingResult
    ) {
        if (direction == selectDirection) {
            return movingResult;
        }
        return NOTTING;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
