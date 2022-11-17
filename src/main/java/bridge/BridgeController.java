package bridge;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();

        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(numberGenerator);
    }

    public void run() {
        int bridgeSize = inputView.readBridgeSize();

        bridgeGame.initGame(bridgeSize);

        move();
    }

    private boolean move() {
        String moving = inputView.readMoving();

        return bridgeGame.move(moving);
    }
}
