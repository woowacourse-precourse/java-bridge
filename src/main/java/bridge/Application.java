package bridge;

import java.util.List;

public class Application {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridge);

        int gameCount = 1;
        boolean game =true;

        while (game) {
            BridgeGame bridgeGame = new BridgeGame(bridge,inputView, outputView);
            if (bridgeGame.move()) {
                outputView.printEndMessage();
                outputView.printMap(bridgeGame.upperLine,bridgeGame.lowerLine);
                outputView.printResult(true, gameCount);
                break;
            }
            game = bridgeGame.retry(inputView.readGameCommand());
            if (!game) {
                outputView.printEndMessage();
                outputView.printMap(bridgeGame.upperLine,bridgeGame.lowerLine);
                outputView.printResult(false, gameCount);
                break;
            }
            gameCount++;
        }

    }
}
