package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeFactory {
    private BridgeFactory() {
    }

    ;

    public static Bridge from(BridgeLength brideLength, List<BridgeMove> steps) {
        checkIsNotNull(brideLength);
        checkStepCountIsEqualToBridgeSize(brideLength, steps);
        checkDoesNotContainNull(steps);
        return new Bridge(brideLength, steps);
    }

    private static void checkIsNotNull(BridgeLength brideLength) {
        if (brideLength == null) {
            throw new NullPointerException("다리의 길이는 null이 될 수 없습니다.");
        }
    }

    private static void checkDoesNotContainNull(List<BridgeMove> steps) {
        if (steps.contains(null)) {
            String stepList = Arrays
                    .stream(BridgeMove.values())
                    .map(BridgeMove::getMoveCommand)
                    .collect(Collectors.joining(","));
            throw new NullPointerException("다리의 각 칸은 " + stepList + " 중 하나의 값을 가져야 합니다.");
        }
    }

    private static void checkStepCountIsEqualToBridgeSize(BridgeLength brideLength, List<BridgeMove> steps) {
        if (!brideLength.isEqualTo(steps.size())) {
            throw new IllegalArgumentException("다리의 길이와 칸의 개수는 같아야 합니다.");
        }
    }
}
