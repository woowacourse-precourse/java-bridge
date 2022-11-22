package bridge.controller;

import static bridge.model.RetryAndQuit.isRetry;
import static bridge.model.SurviveAndDie.isDie;
import static bridge.model.SuccessAndFail.isSuccess;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Position;
import bridge.model.SurviveAndDie;
import bridge.model.SuccessAndFail;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        printStartMessage();
        createBridge();
        attempt();
        printResult();
    }

    private void printStartMessage() {
        outputView.printStartGame();
    }

    private void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void attempt() {
        SuccessAndFail successAndFail = moveUntilSuccessOrFail();
        if (isSuccess(successAndFail)) {
            handleSuccess();
            return;
        }
        handleFail();
    }

    private SuccessAndFail moveUntilSuccessOrFail() {
        for (int index = 0; index < bridgeGame.getBridgeSize(); index++) {
            SurviveAndDie surviveAndDie = moveToDecideSurviveOrDie(index);
            if (isDie(surviveAndDie)) {
                return SuccessAndFail.FAIL;
            }
        }
        return SuccessAndFail.SUCCESS;
    }

    private SurviveAndDie moveToDecideSurviveOrDie(int index) {
        Position position = inputView.readMoving();
        SurviveAndDie surviveAndDie = bridgeGame.move(index, position);
        outputView.printMap(bridgeGame.getDiagram());
        return surviveAndDie;
    }

    private void handleSuccess() {
        bridgeGame.setSuccess();
    }

    private void handleFail() {
        if (isRetry(inputView.readGameCommand())) {
            handleRetryAfterFail();
        }
    }

    private void handleRetryAfterFail() {
        bridgeGame.retry();
        attempt();
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getDiagram(), bridgeGame.successOrFail(), bridgeGame.getAttempts());
    }

}
