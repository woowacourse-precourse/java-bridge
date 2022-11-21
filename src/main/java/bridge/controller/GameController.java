package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;
import static bridge.controller.InputController.getGameCommand;
import static bridge.model.Status.die;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
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

        while (continueGame()) {
            Diagram diagram = new Diagram();
            BridgeGame bridgeGame = new BridgeGame(bridge, diagram);
            int index;
            for (index = 0; index < bridge.getBridgeSize(); index++) {
                Status status = bridgeGame.move(index);
                if (die(status)) {
                    break;
                }
            }
            if (bridge.survivedToTheLast(index)) {
                success = true;
            }
            if (!bridge.survivedToTheLast(index)) {
                GameCommand gameCommand = getGameCommand();
                bridgeGame.retry(gameCommand);
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

    public static void quit() {
        command = GameCommand.QUIT;
    }

    public boolean continueGame() {
        return command == GameCommand.RETRY && !success;
    }
}
