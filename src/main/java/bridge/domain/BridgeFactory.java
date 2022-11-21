package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeFactory {
    private BridgeFactory() {
    }

    ;

    public static Bridge from(BridgeSize bridgeSize, List<BridgeMove> steps) {
        checkIsNotNull(bridgeSize);
        checkStepCountIsEqualToBridgeSize(bridgeSize, steps);
        checkDoesNotContainNull(steps);
        return new Bridge(bridgeSize, steps);
    }

    private static void checkIsNotNull(BridgeSize bridgeSize) {
        if (bridgeSize == null) {
            throw new NullPointerException("다리의 길이는 null이 될 수 없습니다.");
        }
    }

    private static void checkDoesNotContainNull(List<BridgeMove> steps) {
        if (steps.contains(null)) {
            String stepList = Arrays
                    .stream(BridgeMove.values())
                    .map(BridgeMove::getStep)
                    .collect(Collectors.joining(","));
            throw new NullPointerException("다리의 각 칸은 " + stepList + " 중 하나의 값을 가져야 합니다.");
        }
    }

    private static void checkStepCountIsEqualToBridgeSize(BridgeSize bridgeSize, List<BridgeMove> steps) {
        if (bridgeSize.getSize() != steps.size()) {
            throw new IllegalArgumentException("다리의 길이와 칸의 개수는 같아야 합니다.");
        }
    }
}
