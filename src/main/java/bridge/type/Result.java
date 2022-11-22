package bridge.type;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    private String result;

    private Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
