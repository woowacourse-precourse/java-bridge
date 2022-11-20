package bridge.Controller.Service;

import Utils.ValidateUtils;
import bridge.Domain.BridgeGame;
import bridge.Domain.Player;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeGameService {
    private BridgeGame bridgeGame;
    private Player player;

    public BridgeGameService(BridgeGame bridgeGame, Player player) {
        this.bridgeGame = bridgeGame;
        this.player = player;
    }

    public void onePhaseBridgeGame() throws IllegalArgumentException {
        String positionInput = InputView.readMoving();
        ValidateUtils.isValidatePosition(positionInput);
        bridgeGame.move(positionInput);
        String bridgeStatus = bridgeGame.getBridgeStatusAfterMove();
        OutputView.printMap(bridgeStatus);
    }

    public boolean severalPhaseBridgeGame() throws IllegalArgumentException {
        while (true) {
            onePhaseBridgeGame();
            if (bridgeGame.isMoveSuccess() && player.isPlayerInEndOfBridge()) {
                return true;
            }
            if (!bridgeGame.isMoveSuccess()) {
                return false;
            }
        }
    }
}
