package bridge.domain.game;

import bridge.domain.bridge.BridgeMove;

public class BridgeGameService {
    
    private final BridgeGame game;
    
    public BridgeGameService(BridgeGame game) {
        this.game = game;
        this.game.setStatus(BridgeGameStatus.TRYING);
    }
    
    public BridgeGame getGame() {
        return game;
    }
    
    public boolean tryMove(BridgeMove selectMove) {
        if (game.canMoveToNextPosition(selectMove)) {
            game.move(selectMove);
            return true;
        }
        fail(selectMove);
        return false;
    }
    
    private void fail(BridgeMove selectMove) {
        game.fail(selectMove);
        game.setStatus(BridgeGameStatus.FAILURE);
    }
    
    public void retry() {
        game.retry();
        game.setStatus(BridgeGameStatus.TRYING);
    }
    
    public boolean isFinish() {
        if (game.isReachedLastPosition()) {
            game.setStatus(BridgeGameStatus.SUCCESS);
            return true;
        }
        return false;
    }
    
}
