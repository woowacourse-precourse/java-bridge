package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    private int trial = 1;
    private int bridgeSize;
    private List<String> bridge;
    private List<String> userRoute = new ArrayList<>();

    public void simulateGame() {
        initializeGame();
        startGame();
        quitGame();
    }

    private void initializeGame() {
        outputView.printGameStart();
        bridgeSize = inputView.readBridgeSize();

        makeBridge();
    }

    private void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {

    }

    private void quitGame() {

    }
}
