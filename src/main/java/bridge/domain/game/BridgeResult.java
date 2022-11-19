package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.dto.BridgeResultDto;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final List<MoveResult> upBridgeResult;
    private final List<MoveResult> downBridgeResult;

    private MoveResult moveResult;

    public BridgeResult() {
        upBridgeResult = new ArrayList<>();
        downBridgeResult = new ArrayList<>();
    }

    public void updateResult(Square square, boolean result) {
        moveResult = MoveResult.of(result);

        if (square.isUp()) {
            upBridgeResult.add(moveResult);
            downBridgeResult.add(MoveResult.NOTHING);
        }

        if (square.isDown()) {
            downBridgeResult.add(moveResult);
            upBridgeResult.add(MoveResult.NOTHING);
        }
    }

    public BridgeResultDto toDto() {
        return BridgeResultDto.of(upBridgeResult, downBridgeResult);
    }

    public String getResult() {
        return moveResult.value();
    }
}
