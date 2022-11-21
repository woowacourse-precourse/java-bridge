package bridge.controller;

import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.die;
import static bridge.model.SuccessAndFail.isSuccess;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameCommand;
import bridge.model.Position;
import bridge.model.Status;
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
        bridgeGame = new BridgeGame(bridge);
        attempt();
        printResult();
    }

    private void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void attempt() {
        SuccessAndFail successAndFail = moving();

        if (isSuccess(successAndFail)) {
            bridgeGame.setSuccess();
        }

        if (!isSuccess(successAndFail)) {
            GameCommand gameCommand = inputView.readGameCommand();
            if (selectedRetry(gameCommand)) {
                bridgeGame.retry();
                attempt();
            }
        }
    }

    private SuccessAndFail moving() {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            Position position = inputView.readMoving();
            Status status = bridgeGame.move(index, position);
            outputView.printMap(bridgeGame.getDiagram());
            if (die(status)) {
                return SuccessAndFail.FAIL;
            }
        }
        return SuccessAndFail.SUCCESS;
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getDiagram(), bridgeGame.isSuccess(), bridgeGame.getAttempts());
    }

}
