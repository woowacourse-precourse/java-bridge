package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.CurrentBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Map<String, Boolean> gameManager = new HashMap<>();

    public static void main(String[] args) {
        outputView.printStartGame();
        int bridgeSize = inputView.readBridgeSize();

        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        oneGame(bridgeGame);
        restartOrStop(bridgeGame);
    }

    private static void oneGame(BridgeGame bridgeGame) {
        while (true) {
            String readMoving = inputView.readMoving();
            CurrentBridge currentBridge = bridgeGame.move(readMoving);
            outputView.printMap(currentBridge);
            gameManager = bridgeGame.getGameManager();
            boolean isEnd = gameManager.get("isGameEnd");
            if (isEnd)
                break;
        }
    }

    private static void restartOrStop(BridgeGame bridgeGame) {
    }
}
