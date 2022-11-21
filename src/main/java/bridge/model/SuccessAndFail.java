package bridge.model;

import java.util.Arrays;

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
        return SuccessAndFail.from(isSuccess).koreanDisplay;
    }

    public static SuccessAndFail from(boolean isSuccess){
        return Arrays.stream(SuccessAndFail.values())
                .filter(element -> element.isSuccess == isSuccess)
                .findFirst()
                .orElse(null);
    }

    public static boolean isSuccess(SuccessAndFail successAndFail) {
        return successAndFail.isSuccess;
    }

}
