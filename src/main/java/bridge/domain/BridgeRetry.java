package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;
import bridge.view.InputView;

import static bridge.util.BridgeConstant.CONTINUE_GAME;
import static bridge.util.BridgeConstant.QUIT_GAME;
import static bridge.util.BridgeConstant.GAME_RETRY_KEY;

public class BridgeRetry {
    public boolean getContinueCode(Player player) {
        String continueCode = InputView.getInputView().readGameCommand();
        if (continueCode.equals(GAME_RETRY_KEY)) {
            updateGameStatus(player);
            return CONTINUE_GAME;
        }
        return QUIT_GAME;
    }

    private void updateGameStatus(Player player) {
        player.initializePosition();
        player.addTryCount();
        BridgeMap.getBridgeMap().initializeBridges();
    }
}
