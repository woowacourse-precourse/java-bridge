package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CrossResult {
    FAIL(false, "X", "실패"),
    TRUE(true, "O", "성공");
    private boolean result;
    private String successFailureLetter;
    private String successFailureWord;

    CrossResult(boolean result, String successFailureLetter, String successFailureWord) {
        this.result = result;
        this.successFailureLetter = successFailureLetter;
        this.successFailureWord = successFailureWord;
    }

    public static CrossResult findCrossResult(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> key.isResult() == expected)
                .findAny()
                .orElseThrow();
    }

    public static String successFailureLetter(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> key.isResult() == expected)
                .map(CrossResult::getSuccessFailureLetter)
                .collect(Collectors.joining());
    }

    public static String successFailureWord(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> key.isResult() == expected)
                .map(CrossResult::getSuccessFailureWord)
                .collect(Collectors.joining());
    }

    public boolean isResult() {
        return result;
    }

    public String getSuccessFailureLetter() {
        return successFailureLetter;
    }

    public String getSuccessFailureWord() {
        return successFailureWord;
    }
}
