package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CrossResult {
    FAIL(false, "X"),
    TRUE(true, "O");
    private boolean result;
    private String successFailureLetter;

    CrossResult(boolean result, String successFailureLetter) {
        this.result = result;
        this.successFailureLetter = successFailureLetter;
    }

    public static CrossResult  findCrossResult(boolean expected){
        return Arrays.stream(CrossResult.values())
                .filter(key -> key.isResult() == expected)
                .findAny()
                .orElseThrow();
    }

    public static String successFailureLetter(boolean expected){
        return Arrays.stream(CrossResult.values())
                .filter(key -> key.isResult() == expected)
                .map(CrossResult::getSuccessFailureLetter)
                .collect(Collectors.joining());
    }

    public boolean isResult() {
        return result;
    }

    public String getSuccessFailureLetter() {
        return successFailureLetter;
    }
}
