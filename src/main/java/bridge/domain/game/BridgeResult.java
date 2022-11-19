package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeResult {
    private final List<MoveResult> upBridgeResult;
    private final List<MoveResult> downBridgeResult;

    public BridgeResult() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void updateResult(Square square, boolean result) {
        if (square.isUp()) {
            upBridgeResult.add(MoveResult.of(result));
            downBridgeResult.add(MoveResult.NOTHING);
        }

        if (square.isDown()) {
            downBridgeResult.add(MoveResult.of(result));
            upBridgeResult.add(MoveResult.NOTHING);
        }
    }

    public List<String> getUpBridgeResult() {
        return upBridgeResult
                .stream()
                .map(MoveResult::symbol)
                .collect(Collectors.toList());
    }

    public List<String> getDownBridgeResult() {
        return downBridgeResult
                .stream()
                .map(MoveResult::symbol)
                .collect(Collectors.toList());
    }
}
