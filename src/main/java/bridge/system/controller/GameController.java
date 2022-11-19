package bridge.system.controller;

import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
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
    private final BridgeGame bridgeGame;

    public GameController(InputViewInterface inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        Bridge bridge = makeBridge();
        GameResult gameResult = bridgeGame.doGame(bridge);
        handleGameResult(bridge, gameResult);
    }

    private void handleGameResult(Bridge bridge, GameResult gameResult) {
        if (bridge.size() == gameResult.getStepResults().size()) {
            handleSuccess(gameResult);
        }
        if (bridge.size() != gameResult.getStepResults().size()) {
            handleFailure(gameResult);
        }
    }

    private void handleSuccess(GameResult gameResult) {
        outputView.printResult(gameResult, true);
    }

    private void handleFailure(GameResult gameResult) {
        outputView.printResult(gameResult, false);

    }

    private Bridge makeBridge() {
        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        List<Step> steps = Step.from(bridgeMaker.makeBridge(bridgeSize));
        return new Bridge(steps);
    }
}
