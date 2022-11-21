package bridge.controller;

import bridge.BridgeMaker;
import bridge.view.inputview.InputViewInterface;
import bridge.view.outputview.OutputView;
import bridge.vo.Bridge;
import bridge.vo.GameResult;
import bridge.vo.Step;

import java.util.List;

public class GameController {
    private final InputViewInterface inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeController bridgeController;

    public GameController(InputViewInterface inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeController bridgeController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeController = bridgeController;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        Bridge bridge = makeBridge();
        GameResult gameResult = bridgeController.doGame(bridge);

        handleGameResult(bridge, gameResult);
    }

    private Bridge makeBridge() {
        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        List<Step> steps = Step.from(bridgeMaker.makeBridge(bridgeSize));
        return new Bridge(steps);
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
