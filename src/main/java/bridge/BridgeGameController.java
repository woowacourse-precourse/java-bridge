package bridge;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int start() {
        int size = inputView.readBridgeSize();
        bridgeGame.start(size);
        return size;
    }

    public void move(int size) {
        for (int i = 0; i < size; i++) {
            String command = inputView.readMoving();
            bridgeGame.move(command);
        }
    }
}
