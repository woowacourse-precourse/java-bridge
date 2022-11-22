package bridge;

import static bridge.command.GameCommand.RESTART;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        BridgeGame game = initializeGameWithBridgeLength();
        play(game);
    }

    private static BridgeGame initializeGameWithBridgeLength() {
        outputView.printRequestBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(new Bridge(bridge), new ArrayList<>(), 1);
    }

    private static void play(BridgeGame game) {
        outputView.printStart();
        while (!game.isEnd()) {
            moveStep(game);
            boolean continueGame = doBasedOnStepResult(game);
            if (!continueGame) {
                break;
            }
        }
        outputView.printResult(game);
    }

    private static void moveStep(BridgeGame game) {
        outputView.printRequestMoveDirection();
        game.move(inputView.readMoving());
        outputView.printMap(game.analyzeResult());
    }

    private static boolean doBasedOnStepResult(BridgeGame game) {
        if (!game.isStepSuccess()) {
            outputView.printRequestRestartOrQuit();
            String command = inputView.readGameCommand();
            if (!command.equals(RESTART.getKey())) {
                return false;
            }
            game.retry();
        }
        return true;
    }

}