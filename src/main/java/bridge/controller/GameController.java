package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Position;
import bridge.model.Result;
import bridge.model.SuccessAndFail;
import bridge.model.SurviveAndDie;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private Result result;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        startGame();
        createBridge();
        attempt();
        printResult();
    }

    private void startGame() {
        outputView.printStartGame();
        result = Result.byDefault();
    }

    private void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge, result);
    }

    public void attempt() {
        SuccessAndFail successAndFail = moveUntilSuccessOrFail();
        if (successAndFail.isSuccess()) {
            handleSuccess();
            return;
        }
        handleDie();
    }

    private SuccessAndFail moveUntilSuccessOrFail() {
        for (int index = 0; index < bridgeGame.getBridgeSize(); index++) {
            SurviveAndDie surviveAndDie = moveToDecideSurviveOrDie(index);
            if (surviveAndDie.isDie()) {
                return SuccessAndFail.FAIL;
            }
        }
        return SuccessAndFail.SUCCESS;
    }

    private SurviveAndDie moveToDecideSurviveOrDie(int index) {
        Position position = inputView.readMoving();
        SurviveAndDie surviveAndDie = bridgeGame.move(index, position);
        outputView.printMap(result.getDiagram());
        return surviveAndDie;
    }

    private void handleSuccess() {
        result.setSuccess();
    }

    private void handleDie() {
        if (inputView.readGameCommand().isRetry()) {
            handleRetryAfterDie();
        }
    }

    private void handleRetryAfterDie() {
        bridgeGame.retry();
        attempt();
    }

    private void printResult() {
        outputView.printResult(result.getDiagram(), result.getSuccessOrFail(), result.getAttempts());
    }

}
