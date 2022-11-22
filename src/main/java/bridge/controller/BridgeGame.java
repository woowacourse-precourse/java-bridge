package bridge.controller;
import bridge.model.BridgeStatus;
import bridge.constant.Game;

public class BridgeGame {
    private BridgeStatus bridgeStatus = new BridgeStatus();
    public boolean move(String movement, String space) {
        if(movement.equals(space)) {
            bridgeStatus.addStatus(movement, Game.CROSS_SUCCESS);
            return true;
        }
        bridgeStatus.addStatus(movement, Game.CROSS_FAIL);
        return false;
    }
    public boolean retry(String retryOrQuit) {
        if (retryOrQuit.equals(Game.RETRY_GAME)) {
            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.play();
            return true;
        }
        return false;
    }
}
