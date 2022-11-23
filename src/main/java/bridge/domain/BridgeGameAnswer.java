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

    private final Map<Round, Move> answer;

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

    private Map<Round, Move> convertAnswer(List<String> bridge) {
        return convertMap(Round.getRoundsOrderByOrderAsc(), convertDirections(bridge));
    }

    private Map<Round, Move> convertMap(List<Round> rounds, List<Move> moves) {
        return IntStream.range(0, moves.size())
                .boxed()
                .collect(toMap(rounds::get, moves::get));
    }

    private List<Move> convertDirections(List<String> bridge) {
        return bridge.stream()
                .map(Move::of)
                .collect(toList());
    }

    // == public 메서드 ==
    public MoveResult check(Round round, Move move) {
        validate(round);
        if (answer.get(round).equals(move)) {
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAIL;
    }

    private void validate(Round round) {
        if (!answer.containsKey(round)) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidRoundRange());
        }
    }

    public boolean isLastRound(Round round) {
        Round lastRound = Round.valueOf(answer.size());
        return round.equals(lastRound);
    }
}
