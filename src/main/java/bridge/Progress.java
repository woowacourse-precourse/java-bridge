package bridge;

public class Progress {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;
    private static boolean loop = true;

    public boolean game() {
        gameInProcess();
        return getRetry();
    }

    public void makeBridge() {
        while (true) {
            try {
                bridgeGame = new BridgeGame(inputView.readBridgeSize());
                System.out.println(" ");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(outputView.errorMessage(e.getMessage()));
            }
        }
    }

    public void gameInProcess() {
        while (loop) {
            try {
                movingProcess();
            } catch (IllegalArgumentException e) {
                System.out.println(outputView.errorMessage(e.getMessage()));
            }
        }
    }

    public void movingProcess() {
        while (!bridgeGame.isMoveFinish()) {
            loop = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.inputHistory());
        }
    }

    public boolean getRetry() {
        while (true) {
            try {
                return retryValue();
            } catch (IllegalArgumentException e) {
                System.out.println(outputView.errorMessage(e.getMessage()));
            }
        }
    }

    public boolean retryValue() {
        if (!bridgeGame.isSuccess()) {
            loop = true;
            return bridgeGame.retry(inputView.readGameCommand());
        }
        return false;
    }

    public void printResult(int count) {
        outputView.printResult(count, bridgeGame.inputHistory(), bridgeGame.isSuccess());
    }
}
