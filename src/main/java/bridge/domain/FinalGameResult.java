package bridge.domain;

import java.util.Arrays;

public enum FinalGameResult {
    SUCCESS(true, "성공"),
    FAIL(false, "실패");

    private final boolean isSuccess;
    private final String finalResult;

    FinalGameResult(boolean isSuccess, String finalResult) {
        this.isSuccess = isSuccess;
        this.finalResult = finalResult;
    }

    public static FinalGameResult makeFinalGameResult(boolean isSuccess) {
        FinalGameResult finalGameResult = Arrays.stream(values())
                .filter(value -> value.isSuccess == isSuccess)
                .findAny()
                .orElse(null);
        return finalGameResult;
    }

    public String getFinalResult() {
        return finalResult;
    }
}
