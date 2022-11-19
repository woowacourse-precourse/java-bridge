package bridge.domain.bridge;

import bridge.domain.direction.Direction;

import java.util.List;

public class Bridge {

    private static final String OUT_OF_RANGE_MESSAGE = "다리 길이는 3에서 20 사이의 숫자여야 합니다.";
    private static final int MAX_LENGTH = 20;
    private static final int MIN_LENGTH = 3;
    private final List<Direction> directions;

    public Bridge(final List<Direction> directions) {
        validateSize(directions.size());
        this.directions = directions;
    }

    private void validateSize(final int size) {
        if (size > MAX_LENGTH || size < MIN_LENGTH) {
           throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }
}
