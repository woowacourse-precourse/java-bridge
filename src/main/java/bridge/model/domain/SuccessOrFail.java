package bridge.model.domain;

public enum SuccessOrFail {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String korean;
    private final boolean isSuccess;

    SuccessOrFail(String korean, boolean isSuccess) {
        this.korean = korean;
        this.isSuccess = isSuccess;
    }

    public String getKorean() {
        return korean;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
