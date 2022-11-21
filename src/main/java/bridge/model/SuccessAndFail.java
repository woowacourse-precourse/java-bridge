package bridge.model;

public enum SuccessAndFail {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String koreanDisplay;
    private final boolean isSuccess;

    SuccessAndFail(String koreanDisplay, boolean isSuccess) {
        this.koreanDisplay = koreanDisplay;
        this.isSuccess = isSuccess;
    }

    public static String getKoreanDisplay(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.koreanDisplay;
        }
        return FAIL.koreanDisplay;
    }

}
