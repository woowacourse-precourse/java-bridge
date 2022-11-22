package bridge.constant;

public enum ResultState {
    SUCCESS("성공"),
    FAIL("실패");

    private final String state;

    ResultState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}