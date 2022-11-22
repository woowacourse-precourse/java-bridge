package bridge.domain;

import static java.util.stream.Collectors.toList;

import bridge.common.Code;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameResult {
    private final Map<Round, PlayerMove> result = new HashMap<>();

    public BridgeGameResult() {
    }

    public void addResult(Round round, PlayerMove playerMove) {
        result.put(round, playerMove);
    }

    public void reset() {
        result.clear();
    }

    public List<List<MoveResult>> getResult() {
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        return List.of(getMovingResults(Move.UP), getMovingResults(Move.DOWN));
    }

    private List<MoveResult> getMovingResults(Move move) {
        return Round.getRoundsWithSizeOrderByAsc(result.size())
                .stream()
                .map(round -> getMoveResult(round, move))
                .collect(toList());
    }

    private MoveResult getMoveResult(Round round, Move move) {
        PlayerMove playerMove = result.get(round);
        if (playerMove.isNotSameMove(move)) {
            return MoveResult.NOT_MOVE;
        }
        return playerMove.getMoveResult();
    }

    public Code checkGameSuccess() {
        long failCount = Round.getRoundsWithSizeOrderByAsc(result.size())
                .stream()
                .map(result::get)
                .filter(PlayerMove::isFail)
                .count();
        return Code.of(failCount);
    }
}
