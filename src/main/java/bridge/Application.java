package bridge;

import bridge.domain.BridgeAnswer;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePlayer;

public class Application {

    public static void main(String[] args) {
        BridgePlayer bridgePlayer = new BridgePlayer();
        BridgeAnswer bridgeAnswer = new BridgeAnswer();
        BridgeGame bridgeGame = new BridgeGame(bridgePlayer, bridgeAnswer);

        BridgeGameManager bridgeGameController = new BridgeGameManager(bridgeGame);
        bridgeGameController.playGame();
    }
}
