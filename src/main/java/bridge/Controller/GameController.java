package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.Stack;

public class GameController {
    private GameController(BridgeGame bridgeGame) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        callReadBridgeSize(bridgeGame);
        startRun(bridgeGame);
    }

    private void callReadBridgeSize(BridgeGame bridgeGame) {
        bridgeGame.size = new InputView().readBridgeSize();
        startBridgeMaker(bridgeGame);
    }

    private void startBridgeMaker(BridgeGame bridgeGame) {
        bridgeGame.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeGame.size);
    }

    private void startRun(BridgeGame bridgeGame) {
        bridgeGame.user = new Stack<>();
        bridgeGame.idx = 0;
        do {
            moveAndPrintTemporaryResult(bridgeGame);
        } while (runCondition(bridgeGame));
        if (isEndOfTheBridge(bridgeGame)) {
            return;
        }
        startRetry(bridgeGame);
    }

    private void moveAndPrintTemporaryResult(BridgeGame bridgeGame) {
        bridgeGame.move(new InputView().readMoving());
        VisualizeController.getVisualizeController(bridgeGame);
        new OutputView().printMap(bridgeGame);
    }

    private boolean runCondition(BridgeGame bridgeGame) {
        if (bridgeGame.user.peek().equals(bridgeGame.bridge.get(bridgeGame.idx))) {
            bridgeGame.idx++;
            return bridgeGame.idx < bridgeGame.size;
        }
        return false;
    }

    private static boolean isEndOfTheBridge(BridgeGame bridgeGame) {
        if (bridgeGame.idx == bridgeGame.size) {
            new OutputView().printResult(bridgeGame, true);
            return true;
        }
        return false;
    }

    private void startRetry(BridgeGame bridgeGame) {
        if (new InputView().readGameCommand().equals("Q")) {
            new OutputView().printResult(bridgeGame, false);
            bridgeGame.retry();
            return;
        }
        bridgeGame.retry();
        startRun(bridgeGame);
    }

    public static void getGameController() {
        new GameController(BridgeGame.getBridgeGame());
    }

}
