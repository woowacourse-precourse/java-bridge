package bridge.constant;

public enum AfterMovingStatusConstant {

    FAIL(0),
    NEXT_TURN(1),
    SUCCESS(2);

    private final int status;

    AfterMovingStatusConstant(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
