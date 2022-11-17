package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    private int trial = 1;
    private List<String> userRoute = new ArrayList<>();

    public void simulateGame() {
        int bridgeSize = initializeGame();
        List<String> bridge = makeBridge(bridgeSize);
        startGame();
        quitGame();
    }

    private int initializeGame() {
        outputView.printGameStart();
        return inputView.readBridgeSize();
    }

    private List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {

    }

    private void quitGame() {

    }
}
