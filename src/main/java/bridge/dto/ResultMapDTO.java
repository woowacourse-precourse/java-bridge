package bridge.dto;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;

import java.util.List;

public class ResultMapDTO {
    private final List<MoveResult> moveResults;
    private final List<String> movings;
    
    public ResultMapDTO(final BridgeGame bridgeGame) {
        moveResults = bridgeGame.moveResult();
        movings = bridgeGame.movings();
    }
    
    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
    
    public List<String> getMovings() {
        return movings;
    }
}
