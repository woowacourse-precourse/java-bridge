package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;
import bridge.view.InputView;

public class BridgeRetry {
    private final boolean CONTINUE_GAME = true;
    private final boolean QUIT_GAME = false;

    public boolean getContinueCode(Player player) {
        boolean continueCode = InputView.getInputView().readGameCommand();
        if (continueCode) {
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
