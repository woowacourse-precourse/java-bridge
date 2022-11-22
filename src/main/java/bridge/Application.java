package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runBridgeGame();
    }

    static void runBridgeGame() {
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());
        bridgeGame.initialize(bridge);
        crossBridge();
        outputView.printResult(bridgeGame.getRecord(), bridgeGame.getSuccess(),
            bridgeGame.getTrial());
    }

    static void crossBridge() {
        while (!bridgeGame.checkComplete()) {
            outputView.printMap(bridgeGame.move(getMoving()));
            if (bridgeGame.hasFail() && !bridgeGame.retry(getGameCommand())) {
                break;
            }
        }
    }

    static int getBridgeSize() {
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeSize;
    }

    static String getMoving() {
        String moving = "";
        while (true) {
            try {
                moving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moving;
    }

    static String getGameCommand() {
        String gameCommand = "";
        while (true) {
            try {
                gameCommand = inputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return gameCommand;
    }
}
