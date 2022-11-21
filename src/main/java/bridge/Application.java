package bridge;

import bridge.model.Result;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static BridgeMaker bridgeMaker;
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;
    private static Result result;

    public static void main(String[] args) {
        initialize();
        outputView.printStart();
        int bridgeSize = makeBridgeWithUserInput();

        boolean gameOn = true;
        while (gameOn) {
            result.initialize();
            gameOn = proceedGame(bridgeSize);
        }
        outputView.printResult(result);
    }

    private static void initialize() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        result = new Result();
    }

    private static int makeBridgeWithUserInput() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);

        return bridgeSize;
    }

    private static boolean proceedGame(int bridgeSize) {
        int crossedCount = 0;
        while (crossedCount < bridgeSize) {
            boolean crossedBridge = moveBridge();
            if (!crossedBridge) {
                return restartGame();
            }
            crossedCount++;
        }
        return false;
    }

    private static boolean moveBridge() {
        String moving = inputView.readMoving();
        boolean crossedBridge = bridgeGame.move(moving);
        result.storeResultBridges(moving, crossedBridge);
        outputView.printMap(result);
        return crossedBridge;
    }

    private static boolean restartGame() {
        String gameCommand = inputView.readGameCommand();
        boolean isRetry = bridgeGame.retry(gameCommand);
        if (isRetry) {
            result.increaseTryCount();
        }
        if (!isRetry) {
            result.setSuccessToFail();
        }
        return isRetry;
    }
}
