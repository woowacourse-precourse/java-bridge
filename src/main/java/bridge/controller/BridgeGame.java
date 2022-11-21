package bridge.controller;

import bridge.constant.Error;
import bridge.model.BridgeStatus;
import bridge.constant.Game;
import bridge.utils.InputValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge = new ArrayList<>();
    private BridgeStatus bridgeStatus = new BridgeStatus();
    private InputValidator inputValidator = new InputValidator();
    public void setBridge (List<String> bridge) {
        this.bridge = bridge;
    }
    public boolean move(String movement, String space) {
        inputValidator.isMovementValid(movement);
        if(movement.equals(space)) {
            bridgeStatus.addStatus(movement, Game.CROSS_SUCCESS);
            return true;
        }
        bridgeStatus.addStatus(movement, Game.CROSS_FAIL);
        return false;
    }
    public void retry(String retryOrQuit) {
        inputValidator.isRetryValid(retryOrQuit);
        if (retryOrQuit.equals(Game.RETRY_GAME)) {
            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.play();
        }
    }
}
