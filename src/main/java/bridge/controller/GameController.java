package bridge.controller;

import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.die;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameCommand;
import bridge.model.Position;
import bridge.model.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private Bridge bridge;

    public void play() {
        outputView.printStartGame();
        bridge = createBridge();
        bridgeGame = new BridgeGame(bridge);

        attempt();

        outputView.printResult(bridgeGame.getDiagram(), bridgeGame.isSuccess(), bridgeGame.getAttempts());
    }

    public void attempt() {
        boolean isSuccess = moving();

        if (isSuccess) {
            bridgeGame.setSuccess();
        }

        if (!isSuccess) {
            GameCommand gameCommand = inputView.readGameCommand();
            if (selectedRetry(gameCommand)) {
                bridgeGame.retry();
                attempt();
            }
        }
    }

    public boolean moving() {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            Position position = inputView.readMoving();
            Status status = bridgeGame.move(index, position);
            outputView.printMap(bridgeGame.getDiagram());
            if (die(status)) {
                return false;
            }
        }
        return true;
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

}
