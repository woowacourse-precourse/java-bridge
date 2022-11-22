package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 방문했던 결과에 관련된 모든 데이터를 가지고 있는 클래스
 */
final class Visited {
    private final List<Position> positions;
    private final Logger logger;

    Visited() {
        positions = new ArrayList<>();
        logger = new Logger();
    }

    void move(final Position moving, final Bridge bridge) {
        logger.put(moving, bridge.isEqualAtIndex(positions.size(), moving));
        positions.add(moving);
    }

    String toPrintableLog() {
        return logger.calculateLog();
    }

    boolean isRemained(final Bridge bridge) {
        if (isEnd(bridge)) {
            return false;
        }
        return isAllStepCorrect(bridge);
    }

    private boolean isEnd(final Bridge bridge) {
        return positions.size() == bridge.size();
    }

    private boolean isAllStepCorrect(final Bridge bridge) {
        return IntStream.range(0, positions.size())
                .allMatch(index -> bridge.isEqualAtIndex(index, positions.get(index)));
    }

    GameResult result(final Bridge bridge) {
        if (!isEnd(bridge)) {
            return GameResult.FAILURE;
        }
        return GameResult.from(isAllStepCorrect(bridge));
    }
}
