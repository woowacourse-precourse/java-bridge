package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CrossResult {
    FAIL(false, " X ", "실패"),
    Success(true, " O ", "성공"),

    NONE(Boolean.FALSE, "   ", "NONE");
    private Boolean result;
    private String successFailureLetter;
    private String successFailureWord;

    CrossResult(boolean result, String successFailureLetter, String successFailureWord) {
        this.result = result;
        this.successFailureLetter = successFailureLetter;
        this.successFailureWord = successFailureWord;
    }

    public static CrossResult SuccessFailure(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> !key.successFailureWord.matches(NONE.getSuccessFailureWord()))
                .filter(key -> key.isResult() == expected)
                .findAny()
                .orElse(NONE);
    }

    public static String successFailureLetter(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> !key.successFailureWord.matches(NONE.getSuccessFailureWord()))
                .filter(key -> key.isResult() == expected)
                .map(CrossResult::getSuccessFailureLetter)
                .findAny()
                .orElse(NONE.getSuccessFailureLetter());
    }

    public static CrossResult findCrossResult(String input, boolean expected) {
        if (NONE.getSuccessFailureWord().matches(input)) {
            return NONE;
        }
        return SuccessFailure(expected);
    }

    public static String successFailureWord(boolean expected) {
        return Arrays.stream(CrossResult.values())
                .filter(key -> !key.successFailureWord.matches(NONE.getSuccessFailureWord()))
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
