package bridge.model;

public enum GameResult {
    SUCCESS("성공", true),
    FAILURE("실패", false);

    private String status;
    private boolean isSuccess;

    GameResult(String status, boolean isSuccess) {
        this.status = status;
        this.isSuccess = isSuccess;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public static GameResult get(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAILURE;
    }
}
