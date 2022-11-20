package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.dto.BridgeResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class BridgeResult {

    private final List<SquareResult> bridgeResult;

    public BridgeResult() {
        bridgeResult = new ArrayList<>();
    }

    public void updateResult(Square square, boolean result) {
        SquareResult squareResult = new SquareResult(square, MoveResult.of(result));
        bridgeResult.add(squareResult);
        bridgeResult.add(squareResult.getReversed());
    }

    public BridgeResultDto toDto() {
        return BridgeResultDto.of(getResult());
    }

    public Map<Square, List<String>> getResult() {
        return bridgeResult.stream()
                .collect(Collectors.groupingBy(
                        SquareResult::getSquare,
                        Collectors.mapping(SquareResult::getMoveResult, Collectors.toList())));
    }
}
