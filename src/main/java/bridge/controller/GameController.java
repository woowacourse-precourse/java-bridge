package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.model.GameCommand;
import bridge.view.OutputView;

public class GameController {
    private static OutputView outputView = new OutputView();

    private static int attempts;
    private static boolean success;
    private static GameCommand command;

    public GameController() {
        this.attempts = 1;
        this.success = false;
        this.command = GameCommand.RETRY;
    }

    public void play() {

        outputView.printStartGame();

        Bridge bridge = createBridge();

        while (retry()) {
            Diagram diagram = new Diagram();
            BridgeGame bridgeGame = new BridgeGame(bridge, diagram);
            int finalIndex = bridgeGame.move();

            if (bridge.survivedToTheLast(finalIndex)) {
                setSuccess();
            }
            if (!bridge.survivedToTheLast(finalIndex)) {
                bridgeGame.retry();
            }
            outputView.printResult(diagram, success, attempts);

        }
    }


    private static Bridge createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));
        return bridge;
    }

    public static void addAttempts() {
        attempts++;
    }

    public static void setSuccess() {
        success = true;
    }

    public static void quit() {
        command = GameCommand.QUIT;
    }

    public boolean retry() {
        return command == GameCommand.RETRY && !success;
    }
}
