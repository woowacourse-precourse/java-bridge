package bridge.constant;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    private final String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
