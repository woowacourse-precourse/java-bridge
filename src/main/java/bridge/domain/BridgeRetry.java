package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;
import bridge.view.InputView;

import static bridge.util.BridgeConstant.CONTINUE_GAME;
import static bridge.util.BridgeConstant.QUIT_GAME;

public class BridgeRetry {
    public boolean getContinueCode(Player player) {
        boolean continueCode = InputView.getInputView().readGameCommand();
        if (continueCode == CONTINUE_GAME) {
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
