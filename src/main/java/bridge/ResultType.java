package bridge;

public enum ResultType {
    SUCCESS("성공", "O"),
    FAIL("실패", "X");

    private final String state;
    private final String isSuccess;

    ResultType(String state, String success) {
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