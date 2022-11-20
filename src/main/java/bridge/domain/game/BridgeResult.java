package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.dto.BridgeResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class BridgeResult {

    private final List<SquareResult> bridgeResult;

    private SquareResult squareResult;

    public BridgeResult() {
        bridgeResult = new ArrayList<>();
    }

    public void updateResult(Square square, boolean result) {
        squareResult = new SquareResult(square, MoveResult.of(result));
        bridgeResult.add(squareResult);
        bridgeResult.add(squareResult.getReversed());
    }

    public BridgeResultDto toDto() {
        return BridgeResultDto.of(getResult(), squareResult.getSuccess());
    }

    public Map<Square, List<String>> getResult() {
        return bridgeResult.stream()
                .collect(Collectors.groupingBy(
                        SquareResult::getSquare,
                        Collectors.mapping(SquareResult::getMoveResult, Collectors.toList())));
    }
}
