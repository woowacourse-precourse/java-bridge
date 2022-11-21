package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge, 0, true);
        playGame(bridgeGame);
        OutputView.printResult(bridgeGame.getResult());
    }

    public static void playGame(BridgeGame bridgeGame) {
        while (bridgeGame.checkToContinue()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getMap());
        }
        if (bridgeGame.checkSuccess() && InputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
        }
    }
}
