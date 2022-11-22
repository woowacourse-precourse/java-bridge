package bridge;

import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            runBridgeGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void runBridgeGame() {
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame.initialize(bridge);
        crossBridge();
        outputView.printResult(bridgeGame.getRecord(), bridgeGame.getSuccess(),
            bridgeGame.getTrial());
    }

    static void crossBridge() {
        while (!bridgeGame.checkComplete()) {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
            if (bridgeGame.hasFail() && !bridgeGame.retry(inputView.readGameCommand())) {
                break;
            }
        }
    }
}
