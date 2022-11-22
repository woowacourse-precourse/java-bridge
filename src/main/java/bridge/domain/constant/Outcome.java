package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Outcome {
    SUCCESS(true, "성공"),
    FAILED(false, "실패");
    private final boolean successState;
    private final String word;

    Outcome(boolean successState, String word) {
        this.successState = successState;
        this.word = word;
    }

    private static boolean isSuccess(Outcome outcome, boolean successState) {
        return outcome.successState == successState;
    }

    public static Outcome findBySuccess(boolean successState) {
        return Arrays.stream(Outcome.values())
                .filter(outcome -> isSuccess(outcome, successState))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static String getStateWord(boolean successState) {
        Outcome outcome = Outcome.findBySuccess(successState);
        return outcome.word;
    }

}
