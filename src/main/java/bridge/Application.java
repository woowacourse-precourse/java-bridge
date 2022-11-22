package bridge;

import bridge.position.Latitude;

import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        try {
            outputView.printStartMessage();
            List<String> bridge = bridgeMaker.makeBridge(readBridgeSize());
            gameStart(new BridgeGame(bridge));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private static int readBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }

    private static Latitude readMoving() {
        outputView.printMovingInputMessage();
        String moving = inputView.readMoving();
        return Latitude.valueOfDirection(moving);
    }

    private static String readGameCommand() {
        outputView.printGameCommandInputMessage();
        return inputView.readGameCommand();
    }

    private static void gameStart(BridgeGame bridgeGame) {
        do {
            if (bridgeGame.move(readMoving())) {
                outputView.printMap(bridgeGame.getGameResult());
                continue;
            }
            if (readGameCommand().equals("R")) {
                bridgeGame.retry();
            }
        } while (bridgeGame.isProcessing());
        outputView.printResult(bridgeGame.getGameResult());
    }
}
