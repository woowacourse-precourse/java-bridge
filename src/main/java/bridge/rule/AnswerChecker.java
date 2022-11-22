package bridge.rule;

import java.util.Arrays;

public enum AnswerChecker {

    CORRECT(true, "성공"),
    WRONG(false, "실패");

    private final boolean isSuccess;
    private final String word;

    AnswerChecker(boolean isSuccess, String word) {
        this.isSuccess = isSuccess;
        this.word = word;
    }

    public static String convert(boolean isSuccess) {
        AnswerChecker answerChecker = findWord(isSuccess);
        return answerChecker.convertWord();
    }

    private static AnswerChecker findWord(boolean isSuccess) {
        return Arrays.stream(AnswerChecker.values())
                .filter(answerChecker -> isSuccess == answerChecker.isSuccess)
                .findAny()
                .orElseThrow();
    }

    private String convertWord() {
        return this.word;
    }
}
