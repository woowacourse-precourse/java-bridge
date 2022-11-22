package bridge.utils;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeStep {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String step;

    BridgeStep(int number, String step) {
        this.number = number;
        this.step = step;
    }

    private static final Map<String, BridgeStep> STEP_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeStep::getStep, Function.identity())));

    public static BridgeStep findByString(String step) {
        return STEP_MAP.get(step);
    }

    public int getNumber() {
        return number;
    }

    public String getStep() {
        return step;
    }
}
