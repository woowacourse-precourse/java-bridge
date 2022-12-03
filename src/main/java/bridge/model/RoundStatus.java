package bridge.model;

public enum RoundStatus {

    ROUND_SUCCESS("O", true), ROUND_FAIL("X", false);

    private final String display;
    private final boolean isSuccess;

    RoundStatus(String display, boolean isSuccess) {
        this.display = display;
        this.isSuccess = isSuccess;
    }
}
