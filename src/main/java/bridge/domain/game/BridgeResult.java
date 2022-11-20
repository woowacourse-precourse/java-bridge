package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.dto.BridgeResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class BridgeResult {

    private final List<GameResult> bridgeResult;

    public BridgeResult() {
        bridgeResult = new ArrayList<>();
    }

    public void updateResult(Square square, boolean result) {
        GameResult gameResult = new GameResult(square, MoveResult.of(result));
        bridgeResult.add(gameResult);
        bridgeResult.add(gameResult.getReversed());
    }

    public BridgeResultDto toDto() {
        return BridgeResultDto.of(getResult());
    }

    public Map<Square, List<String>> getResult() {
        return bridgeResult.stream()
                .collect(Collectors.groupingBy(
                        GameResult::getSquare,
                        Collectors.mapping(GameResult::getMoveResult, Collectors.toList())));
    }
}
