package bridge.dto;

import bridge.domain.BridgeGameResult;
import bridge.domain.MoveResult;
import java.util.List;

public class MoveResultDto {
    private final List<List<MoveResult>> moveResult;

    private MoveResultDto(BridgeGameResult bridgeGameResult) {
        this.moveResult = bridgeGameResult.getResult();
    }

    public static MoveResultDto from(BridgeGameResult bridgeGameResult) {
        return new MoveResultDto(bridgeGameResult);
    }

    public List<List<MoveResult>> getMoveResult() {
        return moveResult;
    }
}
