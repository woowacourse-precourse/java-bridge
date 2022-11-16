package bridge;

import java.util.List;

public class MainGame {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final List<String> bridge;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private boolean endGame;

    public MainGame() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        endGame = false;
        outputView.printStart();
        outputView.printLengthInput();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void playRound() {

    }

}
