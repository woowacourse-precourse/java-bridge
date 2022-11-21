package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    GameController() {
        int bridgeSize = start();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        run();
    }
    private void run() {
        boolean isRetry = true;
        while(isRetry) {
            play();
            isRetry = bridgeGame.retry();
        }
    }

    private void play() {
        boolean moveResult = true;
        while(moveResult) {
            outputView.printPlay();
            String movingValue = inputView.readMoving();
            moveResult =bridgeGame.move(movingValue);
        }
    }

    private int start() {
        outputView.printStart();
        return inputView.readBridgeSize();
    }
}
