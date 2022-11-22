package bridge.constant;

public enum SuccessFail {
    SUCCESS("성공"),
    FAIL("실패");

    private final String korean;

    SuccessFail(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return this.korean;
    }
}
