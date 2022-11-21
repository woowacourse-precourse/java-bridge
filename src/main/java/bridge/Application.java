package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.BridgeGameManager;
import bridge.domain.*;

public class Application {

    public static void main(String[] args) {
        PositionTable userTable = PositionTable.newInstance();
        Bridge bridge = Bridge.makeBridge();
        BridgeGame bridgeGame = BridgeGame.of(bridge, userTable);
        GameResult gameResult = bridgeGame.startGame();
        gameResult = bridgeGame.retry(gameResult);
        BridgeGameManager.showResult(userTable, gameResult, bridgeGame.getTryNumber());
    }
}
