package bridge.domain;

import bridge.util.Constant;

import java.util.Arrays;

public enum StepResult {

    UPPER_SUCCESS("U", Constant.MOVE_SUCCESS, "O"),
    UPPER_FAIL("U",  Constant.MOVE_FAIL, "X"),
    LOWER_SUCCESS("D", Constant.MOVE_SUCCESS, "O"),
    LOWER_FAIL("D", Constant.MOVE_FAIL, "X"),
    NO_RESULT("null", Constant.MOVE_FAIL, "null");

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
                .orElse(NO_RESULT);
    }

    public String getDirection() {
        return direction;
    }

    public String getResult() {
        return this.result;
    }
}
