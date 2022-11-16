package bridge;

import java.util.List;

public class MainGame {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final List<String> bridge;
    private BridgeGame bridgeGame;
    private boolean endGame;

    public MainGame() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        endGame = false;
        outputView.printStart();
        outputView.printLengthInput();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void playRound() {
        bridgeGame = new BridgeGame(bridge);
        while (!endGame) {
            outputView.printMovementInput();
            inputView.readMoving();
            bridgeGame.move();
        }
    }

}
