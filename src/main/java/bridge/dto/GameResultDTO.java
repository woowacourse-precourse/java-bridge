package bridge.dto;

import bridge.domain.BridgeGame;
import bridge.view.MoveResultDisplay;

import java.util.List;

public class GameResultDTO {
    private final List<MoveResultDisplay> moveResultDisplays;
    private final List<String> movings;
    private final int numberOfTry;
    
    public GameResultDTO(final BridgeGame bridgeGame) {
        moveResultDisplays = MoveResultDisplay.convertToMoveResult(bridgeGame.moveStates());
        movings = bridgeGame.movings();
        numberOfTry = bridgeGame.numberOfTry();
    }
    
    public List<MoveResultDisplay> getMoveResults() {
        return moveResultDisplays;
    }
    
    public List<String> getMovings() {
        return movings;
    }
    
    public int getNumberOfTry() {
        return numberOfTry;
    }
}
