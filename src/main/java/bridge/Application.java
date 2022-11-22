package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.BridgeGameManager;
import bridge.domain.*;
import bridge.viewer.InputView;

public class Application {

    public static void main(String[] args) {
        try {
            PositionTable userTable = PositionTable.newInstance();
            Bridge bridge = Bridge.makeBridge(InputView.readBridgeSize());
            BridgeGame bridgeGame = BridgeGame.of(bridge, userTable);
            GameResult gameResult = bridgeGame.startGame();
            gameResult = bridgeGame.retry(gameResult);
            BridgeGameManager.showResult(userTable, gameResult, bridgeGame.getTryNumber());
        } catch(IllegalArgumentException|IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
