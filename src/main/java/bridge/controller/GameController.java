package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;
import static bridge.controller.InputController.getGameCommand;
import static bridge.controller.InputController.getUserSelection;
import static bridge.model.GameCommand.selectedRetry;
import static bridge.model.Status.findStatus;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.model.GameCommand;
import bridge.model.Position;
import bridge.model.Status;
import bridge.view.OutputView;

public class GameController {
    private static OutputView outputView = new OutputView();

    private int attempts = 1;
    private boolean success = false;
    private GameCommand command = GameCommand.RETRY;


    public void play() {

        outputView.printStartGame();

        Bridge bridge = createBridge();

        while (retry()) {
            Diagram diagram = new Diagram();
            BridgeGame bridgeGame = new BridgeGame(bridge, diagram);
            int finalIndex = bridgeGame.move();

            if (finalIndex == bridge.getBridgeSize()) {
                setSuccess();
                outputView.printResult(diagram, success, attempts);
            }
            if (finalIndex < bridge.getBridgeSize()) {
                GameCommand gameCommand = getGameCommand();
                if (selectedRetry(gameCommand)) {
                    addAttempts();
                }
                if (!selectedRetry(gameCommand)) {
                    quit();
                    outputView.printResult(diagram, success, attempts);
                }
            }
        }
        ;
    }

    private static Bridge createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));
        return bridge;
    }

    public void addAttempts() {
        attempts++;
    }

    public void setSuccess() {
        success = true;
    }

    public void quit() {
        command = GameCommand.QUIT;
    }

    public boolean retry() {
        return command == GameCommand.RETRY && !success;
    }
}
