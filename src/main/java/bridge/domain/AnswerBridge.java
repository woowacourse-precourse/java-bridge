package bridge.domain;

import static bridge.domain.MoveResult.FAIL;
import static bridge.domain.MoveResult.SUCCESS;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class AnswerBridge {

    private static final int BRIDGE_LOWER_BOUND = 3;
    private static final int BRIDGE_UPPER_BOUND = 20;
    private static final String INVALID_BRIDGE_LENGTH_MESSAGE = "다리 길이는 3부터 20 사이여야 합니다.";
    private static final String INVALID_ROUND_MESSAGE = "입력값이 다리의 범위를 벗어났습니다.";

    private final Map<Round, Direction> bridge;

    public AnswerBridge(List<String> bridge) {
        validate(bridge.size());
        this.bridge = toAnswerBridge(bridge);
    }

    private void validate(int size) {
        if (size < BRIDGE_LOWER_BOUND || BRIDGE_UPPER_BOUND < size) {
            throw new IllegalArgumentException(INVALID_BRIDGE_LENGTH_MESSAGE);
        }
    }

    private Map<Round, Direction> toAnswerBridge(List<String> bridge) {
        return mapRoundToDirection(Round.naturalOrder(), toDirectionList(bridge));
    }

    private List<Direction> toDirectionList(List<String> bridge) {
        return bridge.stream()
                .map(Direction::toEnum)
                .collect(toList());
    }

    private Map<Round, Direction> mapRoundToDirection(List<Round> rounds, List<Direction> directions) {
        return IntStream.range(0, directions.size())
                .boxed()
                .collect(toMap(rounds::get, directions::get));
    }

    public MoveResult check(Round round, Direction direction) {
        validateRound(round);
        Direction validDirection = bridge.get(round);
        if (validDirection.isNotSameDirection(direction)) {
            return FAIL;
        }
        return SUCCESS;
    }

    private void validateRound(Round round) {
        if (!bridge.containsKey(round)) {
            throw new IllegalArgumentException(INVALID_ROUND_MESSAGE);
        }
    }

    public boolean isLastRound(Round round) {
        Round lastRound = Round.valueOf(bridge.size());
        return lastRound.equals(round);
    }
}
