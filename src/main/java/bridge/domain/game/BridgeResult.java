package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.dto.BridgeResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeResult {

    private final List<SquareResult> bridgeResult;

    private SquareResult squareResult;

    public BridgeResult() {
        bridgeResult = new ArrayList<>();
    }

    public void updateResult(SquareResult result) {
        squareResult = result;
        bridgeResult.add(result);
        bridgeResult.add(result.getReversed());
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
