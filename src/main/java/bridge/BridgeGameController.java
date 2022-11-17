package bridge;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }



    void start() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
        play();
    }

    private void play() {
        String moving = inputView.readMoving();
        boolean success = bridgeGame.move(moving);
        if (!success) {
            retry();
            return;
        }
        if (!bridgeGame.isCompleted()) {
            play();
        }
        print();
    }

    private void print() {
        outputView.printResult();
    }

    private void retry() {
        String answer = inputView.readGameCommand();
        if (isRetry(answer)) {
            bridgeGame.retry();
            play();
        }
    }

    private boolean isRetry(String answer) {
        return answer.equals("R");
    }
}
