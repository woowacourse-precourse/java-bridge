package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class Visited {
    private final List<Position> positions;
    private final Logger logger;

    public Visited() {
        positions = new ArrayList<>();
        logger = new Logger();
    }

    public void move(Position moving, Bridge bridge) {
        logger.put(moving, bridge.isEqualAtIndex(positions.size(), moving));
        positions.add(moving);
    }

    public String toPrintableLog() {
        return logger.calculateLog();
    }

    public boolean isRemained(Bridge bridge) {
        if (isEnd(bridge)) {
            return false;
        }
        return isAllStepCorrect(bridge);
    }

    private boolean isEnd(Bridge bridge) {
        return positions.size() == bridge.size();
    }

    private boolean isAllStepCorrect(Bridge bridge) {
        return IntStream.range(0, positions.size())
                .allMatch(index -> bridge.isEqualAtIndex(index, positions.get(index)));
    }

    public GameResult result(Bridge bridge) {
        if (!isEnd(bridge)) {
            return GameResult.FAILURE;
        }
        return GameResult.from(isAllStepCorrect(bridge));
    }
}
