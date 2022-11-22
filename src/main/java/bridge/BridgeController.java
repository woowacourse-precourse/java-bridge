package bridge;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void run() {
        outputView.printStart();
        outputView.printAskLength();
        while (true) {
            try {
                bridgeGame = new BridgeGame(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
