package bridge.domain;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import bridge.common.ErrorMessage;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class BridgeGameAnswer {
    private static final int BRIDGE_LOWER_BOUND = 3;
    private static final int BRIDGE_UPPER_BOUND = 20;

    private final Map<Round, Direction> answer;

    public BridgeGameAnswer(List<String> bridge) {
        validate(bridge);
        this.answer = convertAnswer(bridge);
    }

    // == 생성 관련 메서드 ==
    private void validate(List<String> bridge) {
        int size = bridge.size();
        if (size < BRIDGE_LOWER_BOUND || size > BRIDGE_UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidBridgeSize());
        }
    }

    private Map<Round, Direction> convertAnswer(List<String> bridge) {
        return convertMap(Round.getRoundsOrderByOrderAsc(), convertDirections(bridge));
    }

    private Map<Round, Direction> convertMap(List<Round> rounds, List<Direction> directions) {
        return IntStream.range(0, directions.size())
                .boxed()
                .collect(toMap(rounds::get, directions::get));
    }

    private List<Direction> convertDirections(List<String> bridge) {
        return bridge.stream()
                .map(Direction::of)
                .collect(toList());
    }

    // == public 메서드 ==
    public MovingResult check(Round round, Direction direction) {
        validate(round);
        if (answer.get(round).equals(direction)) {
            return MovingResult.SUCCESS;
        }
        return MovingResult.FAIL;
    }

    private void validate(Round round) {
        if (!answer.containsKey(round)) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidRoundRange());
        }
    }
}
