package bridge.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeStep {
    U(1),
    D(0);

    public static final String INVALID_NUMBER_MESSAGE = "U, D 어느 쪽에도 해당하지 않는 값입니다.";
    private final int number;

    BridgeStep(int number) {
        this.number = number;
    }

    public static String getByNumber(int number) {
        return Arrays.stream(BridgeStep.values())
                .filter(value -> number == value.number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER_MESSAGE))
                // TODO: IllegalArgumentException 이 적절하지 않을 수 있다.
                .toString();
    }

    public static BridgeStep getByValue(String value) {
        return Arrays.stream(BridgeStep.values())
                .filter(bridgeStep -> bridgeStep.toString().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER_MESSAGE));
                // TODO: IllegalArgumentException 이 적절하지 않을 수 있다.
    }

    public static List<BridgeStep> from(List<String> steps) {
        return steps.stream()
                .map(BridgeStep::getByValue)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
