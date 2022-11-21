package bridge.controller;

import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.SurviveAndDie.die;
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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private Bridge bridge;

    public void play() {
        outputView.printStartGame();
        createBridge();
        attempt();
        printResult();
    }

    private void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void attempt() {
        SuccessAndFail successAndFail = moving();
        handleSuccess(successAndFail);
        handleFail(successAndFail);
    }
    private SuccessAndFail moving() {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            SurviveAndDie surviveAndDie = moveOnce(index);
            if (die(surviveAndDie)) {
                return SuccessAndFail.FAIL;
            }
        }
        return SuccessAndFail.SUCCESS;
    }

    private SurviveAndDie moveOnce(int index) {
        Position position = inputView.readMoving();
        SurviveAndDie surviveAndDie = bridgeGame.move(index, position);
        outputView.printMap(bridgeGame.getDiagram());
        return surviveAndDie;
    }

    private void handleSuccess(SuccessAndFail successAndFail) {
        if (isSuccess(successAndFail)) {
            bridgeGame.setSuccess();
        }
    }

    private void handleFail(SuccessAndFail successAndFail) {
        if (!isSuccess(successAndFail)) {
            if (selectedRetry(inputView.readGameCommand())) {
                bridgeGame.retry();
                attempt();
            }
        }
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getDiagram(), bridgeGame.successOrFail(), bridgeGame.getAttempts());
    }

}
