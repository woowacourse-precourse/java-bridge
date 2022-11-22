package bridge;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void run() {
        outputView.printStart();
        outputView.printAskLength();
        makeBridge();
        System.out.println();
    }

    private void makeBridge() {
        while (true) {
            try {
                bridgeGame = new BridgeGame(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void playGame() {
        do {
            outputView.printAskDirection();
            move();
            outputView.printMap(bridgeGame.makeBridgeResult());
        } while (bridgeGame.isNotEnd());
    }

    private void move() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
