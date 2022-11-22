package bridge.validator;

import bridge.constant.ErrorConstant;

public class InputNextStepValidator {

    private static final String UP_STEP_INITIAL = "U";
    private static final String DOWN_STEP_INITIAL = "D";

    public void validate(String inputNextStep) {
        if (isInputNextStepNotUOrNotD(inputNextStep)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "이동할 칸은 U또는 D여야합니다.");
        }
    }

    private boolean isInputNextStepNotUOrNotD(String inputNextStep) {
        return !inputNextStep.equals(UP_STEP_INITIAL) && !inputNextStep.equals(DOWN_STEP_INITIAL);
    }
}
