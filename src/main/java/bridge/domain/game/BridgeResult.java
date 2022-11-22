package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.dto.BridgeResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeResult {

    private static final int LAST_RESULT_INDEX = 2;

    private final List<SquareResult> bridgeResult;

    public BridgeResult() {
        bridgeResult = new ArrayList<>();
    }

    public void updateResult(SquareResult result) {
        bridgeResult.add(result);
        bridgeResult.add(result.getReversed());
    }

    public BridgeResultDto toDto() {
        return BridgeResultDto.of(getResult());
    }

    public Map<Square, List<String>> getResult() {
        return bridgeResult.stream()
                .collect(Collectors.groupingBy(
                        SquareResult::getSquare,
                        Collectors.mapping(result -> result.getMoveResult().symbol(),
                                Collectors.toList())));
    }

    public boolean isSuccess() {
        return bridgeResult
                .get(bridgeResult.size() - LAST_RESULT_INDEX)
                .isMoveSuccess();
    }

    public String getMoveSuccessResult() {
        return bridgeResult
                .get(bridgeResult.size() - LAST_RESULT_INDEX)
                .getMoveResult()
                .value();
    }
}
