package bridge.enums;

import bridge.constant.ErrorConstant;

import java.util.Arrays;

public enum Step {

    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String initial;

    Step(int number, String initial) {
        this.number = number;
        this.initial = initial;
    }

    public static String getMovableStepInitial(int movableStepNumber) {
        return Arrays.stream(Step.values())
                .filter(step -> step.number == movableStepNumber)
                .map(step -> step.initial)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorConstant.ERROR_PREFIX + "건널 수 있는 칸 설정 숫자는 0 또는 1이어야합니다."));
    }
}
