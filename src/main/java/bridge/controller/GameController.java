package bridge.controller;

import bridge.view.outputview.OutputView;
import bridge.vo.Bridge;
import bridge.vo.GameResult;

public class GameController {
    private final OutputView outputView;
    private final BridgeController bridgeController;

    public GameController(OutputView outputView, BridgeController bridgeController) {
        this.outputView = outputView;
        this.bridgeController = bridgeController;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        Bridge bridge = bridgeController.makeBridge();
        GameResult gameResult = bridgeController.doGame(bridge);

        handleGameResult(bridge, gameResult);
    }

    private void handleGameResult(Bridge bridge, GameResult gameResult) {
        boolean isFinished = gameResult.isFinishedFrom(bridge);
        if (isFinished) {
            handleSuccess(gameResult);
        }
        if (!isFinished) {
            handleFailure(gameResult);
        }
    }

    private void handleSuccess(GameResult gameResult) {
        outputView.printResult(gameResult, true);
    }

    private void handleFailure(GameResult gameResult) {
        outputView.printResult(gameResult, false);
    }
}
