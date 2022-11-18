package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class Visited {
    private final List<Position> visited;
    private final Logger logger;

    public Visited() {
        visited = new ArrayList<>();
        logger = new Logger();
    }

    public void move(Position moving, Bridge bridge) {
        logger.put(moving, bridge.isEqualAtIndex(visited.size(), moving));
        visited.add(moving);
    }

    public String printVisited() {
        return logger.calculateMap();
    }

    public boolean isRemained(Bridge bridge) {
        if (isEnd(bridge)) {
            return false;
        }
        return isAllStepCorrect(bridge);
    }

    private boolean isEnd(Bridge bridge) {
        return visited.size() == bridge.size();
    }

    private boolean isAllStepCorrect(Bridge bridge) {
        return IntStream.range(0, visited.size())
                .allMatch(index -> bridge.isEqualAtIndex(index, visited.get(index)));
    }

    public GameResult result(Bridge bridge) {
        if (!isEnd(bridge)) {
            return GameResult.FAILURE;
        }
        return GameResult.from(isAllStepCorrect(bridge));
    }
}
