package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeFactory {
    private BridgeFactory() {
    }

    ;

    public static Bridge from(int size, List<String> moves) {
        checkStepCountIsEqualToBridgeSize(size, moves);
        checkDoesNotContainNull(moves);
        List<BridgeMove> passable = moves
                .stream()
                .map(BridgeMove::getBridgeMoveByMoveCommand)
                .collect(Collectors.toList());
        return new Bridge(size, passable);
    }


    private static void checkDoesNotContainNull(List<String> moves) {
        if (moves.contains(null)) {
            String stepList = Arrays
                    .stream(BridgeMove.values())
                    .map(BridgeMove::getMoveCommand)
                    .collect(Collectors.joining(","));
            throw new NullPointerException("다리의 각 칸은 " + stepList + " 중 하나의 값을 가져야 합니다.");
        }
    }

    private static void checkStepCountIsEqualToBridgeSize(int size, List<String> moves) {
        if (size != (moves.size())) {
            throw new IllegalArgumentException("다리의 길이와 칸의 개수는 같아야 합니다.");
        }
    }
}
