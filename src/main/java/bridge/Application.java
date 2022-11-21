package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView printer = new OutputView();
        InputView read = new InputView();
        printer.printStartMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(read.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.runGame();
    }
}
