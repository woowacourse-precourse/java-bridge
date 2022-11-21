package bridge.controller;

import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.die;
import static bridge.model.Status.findStatus;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
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
    private Diagram diagram;

    public void play() {
        outputView.printStartGame();
        diagram = new Diagram();
        bridge = createBridge();
        bridgeGame = new BridgeGame(bridge);

        attempt();

        outputView.printResult(diagram, bridgeGame.isSuccess(), bridgeGame.getAttempts());
    }

    public void attempt() {
        int finalIndex = moving();

        if (bridge.survivedToTheLast(finalIndex)) {
            bridgeGame.setSuccess();
        }

        if (!bridge.survivedToTheLast(finalIndex)) {
            GameCommand gameCommand = inputView.readGameCommand();
            if (selectedRetry(gameCommand)) {
                bridgeGame.retry();
                diagram = new Diagram();
                attempt();
            }
        }
    }

    public int moving() {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            Position position = inputView.readMoving();
            Status status = bridgeGame.move(index, position);
            diagram.updateDiagrams(position, status);
            outputView.printMap(diagram);
            if (die(status)) {
                return index;
            }
        }
        return bridge.getBridgeSize();
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

}
