package bridge.constant;

public enum ResultState {
    SUCCESS("성공"),
    FAIL("실패");

    private final String result;

    ResultState(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
