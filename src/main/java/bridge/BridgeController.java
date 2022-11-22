package bridge;

import java.util.List;

public class BridgeController {

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge;
    public void run() {
        boolean success = false;
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (String s : bridge)
            System.out.print(s + " ");
        for (int i = 0; i < bridgeSize; i++) {
            String direction = inputView.readMoving();
            boolean retryOption = bridgeGame.move(direction);
            outputView.printMap(bridgeGame);
            if (!retryOption) {
                if (!inputView.readGameCommand()) {
                    break;
                }
                i = -1;
                bridgeGame.retry();
            }
            if (i == bridgeSize - 1) {
                success = true;
            }
        }
        outputView.printResult(bridgeGame, success);
    }
}