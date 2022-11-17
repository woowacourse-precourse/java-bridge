package bridge.dto;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;

import java.util.List;

public class GameResultDTO {
    private final List<MoveResult> moveResults;
    private final List<String> movings;
    private final int numberOfTry;
    
    public GameResultDTO(final BridgeGame bridgeGame) {
        moveResults = bridgeGame.moveResult();
        movings = bridgeGame.movings();
        numberOfTry = bridgeGame.numberOfTry();
    }
    
    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
    
    public List<String> getMovings() {
        return movings;
    }
    
    public int getNumberOfTry() {
        return numberOfTry;
    }
}
