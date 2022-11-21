package bridge.domain.bridge;

import bridge.domain.direction.Direction;

import java.util.List;

import static bridge.domain.bridge.CrossStatus.*;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class Bridge {

    private static final String OUT_OF_RANGE_MESSAGE = "다리 길이는 3에서 20 사이의 숫자여야 합니다.";

    private static final int MAX_LENGTH = 20;
    private static final int MIN_LENGTH = 3;

    private final List<Direction> directions;

    public Bridge(final List<Direction> directions) {
        validateSize(directions.size());
        this.directions = unmodifiableList(directions);
    }

    public static Bridge fromStrings(final List<String> bridge) {
        return new Bridge(bridge.stream()
                .map(Direction::ofSymbol)
                .collect(toList()));
    }

    private void validateSize(final int size) {
        if (size > MAX_LENGTH || size < MIN_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public CrossStatus cross(final List<Direction> path) {
        if (isFailPath(path)) {
            return FAIL;
        }
        return judgeSuccessOrGoing(path.size());
    }

    private boolean isFailPath(final List<Direction> path) {
        for (int i = 0; i < path.size(); i++) {
            if (isDifferent(path.get(i), directions.get(i))) {
                return true;
            }
        }
        return false;
    }

    private CrossStatus judgeSuccessOrGoing(final int size) {
        if (directions.size() == size) {
            return SUCCESS;
        }
        return GOING;
    }

    private boolean isDifferent(final Direction path,
                                final Direction target) {
        return path != target;
    }
}
