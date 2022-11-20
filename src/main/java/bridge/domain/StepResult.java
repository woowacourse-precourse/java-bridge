package bridge.domain;

import java.util.Arrays;

public enum StepResult {

    UPPER_SUCCESS("U", true, "O"),
    UPPER_FAIL("U",  false, "X"),
    LOWER_SUCCESS("D", true, "O"),
    LOWER_FAIL("D", false, "X");

    private final String direction;
    private final boolean passed;
    private final String result;

    StepResult(String direction, boolean passed, String result) {
        this.direction = direction;
        this.passed = passed;
        this.result = result;
    }

    public static StepResult getStepResult(String moving, boolean moveFlag) {
        return Arrays.stream(values())
                .filter(stepResult -> stepResult.direction.equals(moving))
                .filter(stepResult -> stepResult.passed == moveFlag)
                .findAny()
                .orElse(null);
    }

    public String getDirection() {
        return direction;
    }

    public String getResult() {
        return this.result;
    }
}
