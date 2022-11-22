package bridge.view.constant;

public enum GameResult {

    SUCCESS(true, "성공"),
    FAIL(false, "실패");

    private final boolean status;
    private final String value;

    GameResult(boolean status, String value) {
        this.status = status;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GameResult get(boolean status) {
        if (status) {
            return SUCCESS;
        }
        return FAIL;
    }
}
