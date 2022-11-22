package bridge.utils.constants;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Result {
    UP_CORRECT("U", true),
    UP_INCORRECT("U", false),
    DOWN_CORRECT("D", true),
    DOWN_INCORRECT("D", false);

    private final String step;
    private final boolean correct;

    Result(String step, boolean correct) {
        this.step = step;
        this.correct = correct;
    }

    public static Result getResult(String step, boolean correct) {
        return Arrays.stream(Result.values())
                .filter(result -> result.step.equals(step) && result.correct == correct)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public String getStep() {
        return step;
    }

    public boolean isCorrect() {
        return correct;
    }
}
