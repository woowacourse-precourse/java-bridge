package bridge;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        outputView.printStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        do {
            for (int space = 0; space < bridge.size(); space++) {
                if(!bridgeGame.getResult()){
                    break;
                }
                bridgeGame.move(inputView.readMoving(), bridge.get(space));
                outputView.printMap();
            }
            bridgeGame.addGameCount();
        } while (!bridgeGame.retry(inputView.readGameCommand()));
        outputView.printResult();
    }
}
