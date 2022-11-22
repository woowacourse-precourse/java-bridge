package bridge.value;

public enum GameSuccessStatus {

    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    GameSuccessStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static GameSuccessStatus calcGameStatus(boolean isSuccess) {
        if(isSuccess) {
            return SUCCESS;
        }

        return FAIL;
    }
}
