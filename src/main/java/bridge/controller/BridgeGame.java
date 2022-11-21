package bridge.controller;
import bridge.model.BridgeStatus;
import bridge.constant.Game;
import bridge.utils.InputValidator;

public class BridgeGame {
    private BridgeStatus bridgeStatus = new BridgeStatus();
    private InputValidator inputValidator = new InputValidator();
    public boolean move(String movement, String space) {
        inputValidator.isMovementValid(movement);
        if(movement.equals(space)) {
            bridgeStatus.addStatus(movement, Game.CROSS_SUCCESS);
            return true;
        }
        bridgeStatus.addStatus(movement, Game.CROSS_FAIL);
        return false;
    }
    public boolean retry(String retryOrQuit) {
        inputValidator.isRetryValid(retryOrQuit);
        if (retryOrQuit.equals(Game.RETRY_GAME)) {
            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.play();
            return true;
        }
        return false;
    }
}
