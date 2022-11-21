package bridge.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Step {
    U(1),
    D(0);

    public static final String INVALID_VALUE_MESSAGE = "U, D 어느 쪽에도 해당하지 않는 값입니다.";
    private final int number;

    Step(int number) {
        this.number = number;
    }

    public static String getByNumber(int number) {
        return Arrays.stream(Step.values())
                .filter(value -> number == value.number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE_MESSAGE))
                .toString();
    }

    public static Step getByValue(String value) {
        return Arrays.stream(Step.values())
                .filter(bridgeStep -> bridgeStep.toString().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE_MESSAGE));
    }

    public static List<Step> from(List<String> steps) {
        return steps.stream()
                .map(Step::getByValue)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
