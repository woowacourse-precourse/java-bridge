package bridge.model;

import bridge.constant.Game;
import bridge.controller.GamePlayer;
import bridge.utils.InputValidator;

public class GameRetry {
    InputValidator inputValidator = new InputValidator();
    public void retryOrQuit(String retry) {
        inputValidator.isRetryValid(retry);
        if(retry.equals(Game.RETRY_GAME)) {
            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.play();
        }
    }
}
