package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(List<String> generatedBridge) {
        return new Bridge(generatedBridge);
    }

    public Result play(ExpectedBridge expectedBridge) {
        if (isSameWith(expectedBridge.getExpectation())) {
            return Result.WIN;
        }
        if (isPartOf(expectedBridge.getExpectation())) {
            return Result.KEEP;
        }
        return Result.LOSE;
    }

    private boolean isSameWith(List<String> expectation) {
        return bridge.equals(expectation);
    }
    private boolean isPartOf(List<String> expectation) {
        return bridge.subList(0,expectation.size()).equals(expectation);
    }
}
