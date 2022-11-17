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
            outputView.printMap(bridgeGame.printWrongResult());
            retry();
            return;
        }
        if (!bridgeGame.isCompleted()) {
            outputView.printMap(bridgeGame.printRightResult());
            play();
            return;
        }
        printSuccessResult();
    }

    private void printSuccessResult() {
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.printRightResult());
        outputView.printResult(OutputView.SUCCESS_MESSAGE, bridgeGame.getRetryCount());
    }


    private void retry() {
        String answer = inputView.readGameCommand();
        if (isRetry(answer)) {
            bridgeGame.retry();
            play();
            return;
        }
        printFailureResult();
    }

    private void printFailureResult() {
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.printWrongResult());
        outputView.printResult(OutputView.FAILURE_MESSAGE, bridgeGame.getRetryCount());
    }


    private boolean isRetry(String answer) {
        return answer.equals("R");
    }
}
