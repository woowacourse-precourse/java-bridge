package bridge.domain;

import bridge.utils.Constants.OutputState;
import java.util.List;
import bridge.BridgeMaker;
import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Program {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static BridgeGame bridgeGame;

    private Program() {
    }

    public static void init() {
        startGame();
        makeBridge();
        playGame();
        finishGame();
    }

    private static void startGame() {
        outputView.printMessage(OutputState.START_GAME);
    }

    private static void makeBridge() {
        outputView.printMessage(OutputState.INPUT_BRIDGE_LENGTH);

        int bridgeSize = getBridgeSize();
        createBridge(bridgeSize);
    }

    private static int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }

    private static void createBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame.setBridge(bridge);
    }

    private static void playGame() {
        while (true) {
            setupGame();
            boolean isContinue = proceedGame();
            if (isContinue) {
                continue;
            }
            break;
        }
    }

    private static void setupGame() {
        bridgeGame = new BridgeGame();
        BridgeGame.increaseAttemptCount();
    }

    private static boolean proceedGame() {
        while (true) {
            if (!generateMovement()) {
                return askToRetryGame();
            }
            if (bridgeGame.isSuccessFinish()) {
                return false;
            }
        }
    }

    private static boolean generateMovement() {
        outputView.printMessage(OutputState.INPUT_MOVE_DIRECTION);
        String direction = getDirection();

        boolean isSuccess = bridgeGame.move(direction);
        outputView.printMap(bridgeGame);

        return isSuccess;
    }

    private static String getDirection() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }

    private static boolean askToRetryGame() {
        outputView.printMessage(OutputState.INPUT_RETRY_COMMAND);
        String command = getRetryCommand();
        return bridgeGame.retry(command);
    }

    private static String getRetryCommand() {
        while (true) {
            try {
                return inputView.readRetryCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }

    private static void finishGame() {
        outputView.printResult(bridgeGame);
    }
}
