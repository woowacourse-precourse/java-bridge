package bridge;

import java.util.List;

public class BridgeGameController {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static BridgeGame bridgeGame = new BridgeGame();
    private static int bridgeSize = 0;
    private static String moving = "";
    private static String gameCommand = "";

    public static void runBridgeGame() {
        setBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.initialize(bridge);
        crossBridge();
        outputView.printResult(bridgeGame.getRecord(), bridgeGame.getSuccess(),
            bridgeGame.getTrial());
    }

    private static void crossBridge() {
        while (!bridgeGame.checkComplete()) {
            setMoving();
            outputView.printMap(bridgeGame.move(moving));
            if (bridgeGame.hasFail() && !retryOption()) {
                break;
            }
        }
    }

    private static boolean retryOption() {
        setGameCommand();
        return bridgeGame.retry(gameCommand);
    }

    private static void setBridgeSize() {
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setMoving() {
        while (true) {
            try {
                moving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setGameCommand() {
        while (true) {
            try {
                gameCommand = inputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
