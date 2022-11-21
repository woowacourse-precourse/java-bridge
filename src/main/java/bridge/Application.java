package bridge;

import bridge.service.BridgeGame;
import bridge.domain.CurrentBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;
import java.util.Map;

import static bridge.constant.Constant.*;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Map<String, Boolean> gameManager = new HashMap<>();
    private static boolean gameStatus = ON_GOING;

    public static void main(String[] args) {
        BridgeGame bridgeGame = startGame();
        while (gameStatus) {
            CurrentBridge gameBridge = oneGame(bridgeGame);
            manageGame(bridgeGame, gameBridge);
        }
    }

    private static BridgeGame startGame() {
        outputView.printStartGame();
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private static CurrentBridge oneGame(BridgeGame bridgeGame) {
        while (true) {
            String readMoving = inputView.readMoving();
            CurrentBridge currentBridge = bridgeGame.move(readMoving);
            outputView.printMap(currentBridge);
            gameManager = bridgeGame.getGameManager();
            if (gameManager.get("isOneGameEnd")) {
                return currentBridge;
            }
        }
    }

    private static void manageGame(BridgeGame bridgeGame, CurrentBridge gameBridge) {
        boolean successGame = gameManager.get("isSuccessGame");
        if (!successGame) {
            gameStatus = restartOrQuit(bridgeGame);
        }
        if (!gameStatus || successGame) {
            outputView.printResult(gameBridge, successGame, bridgeGame.getTrialCount());
            gameStatus = QUIT;
        }
    }

    private static boolean restartOrQuit(BridgeGame bridgeGame) {
        String readGameCommand = inputView.readGameCommand();
        if (readGameCommand.equals(RESTART)) {
            bridgeGame.retry();
            return RE;
        }
        return QUIT;
    }
}
