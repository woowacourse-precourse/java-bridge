package bridge;

public enum MovingType {
    SUCCESS("성공", "O"),
    FAIL("실패", "X");

    private final String state;
    private final String isSuccess;

    MovingType(String state, String success) {
        this.state = state;
        this.isSuccess = success;
    }

    public String getState() {
        return this.state;
    }

    public String getIsSuccess() {
        return this.isSuccess;
    }
}