package bridge;

public class BridgeGameController {

    private final InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
    }

    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";

    void start() {
        System.out.println(START_GAME);
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
