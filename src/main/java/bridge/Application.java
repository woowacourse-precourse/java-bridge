package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Checker checker = new Checker();
    private BridgeGame bridgeGame;

    public static void main(String[] args) {
        new Application().play();
    }

    private void play() {
        outputView.printStart();
        bridgeGame = bridgeGameStart();
        bridgeGameContinue(bridgeGame);
        outputView.printResult(bridgeGame);
        outputView.printGameSuccess(checker.checkGameSuccess(bridgeGame));
        outputView.printGameTry(bridgeGame);
    }

    private BridgeGame bridgeGameStart() {
        int bridgeSize = inputBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        return bridgeGame;
    }

    private int inputBridgeSize() {
        outputView.printInputSize();
        int bridgeSize = -1;
        while (bridgeSize < 0) {
            try {
                bridgeSize = checker.checkValidate(inputView.readBridgeSize());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException);
            }
        }
        return bridgeSize;
    }

    private String inputMove() {
        outputView.printSelectMove();
        String move;
        try {
            move = inputView.readMoving();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);
            move = inputMove();
        }
        return move;
    }

    private void bridgeGameContinue(BridgeGame bridgeGame) {
        bridgeGame.move(inputMove());
        outputMove(bridgeGame);
        boolean isContinue = checker.checkBridgeGameResult(bridgeGame);
        if (!isContinue) {
            isContinue = retryGame(bridgeGame);
        }
        if (isContinue && !(checker.checkGameSuccess(bridgeGame))) {
            bridgeGameContinue(bridgeGame);
        }
    }

    private void outputMove(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame);
    }

    private String inputRetry() {
        outputView.printSelectRetry();
        String gameCommand = null;
        while (gameCommand == null) {
            try {
                gameCommand = inputView.readGameCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException);
            }
        }
        return gameCommand;
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        boolean retry = checker.checkRetry(inputRetry());
        if (retry) {
            bridgeGame.retry();
        }
        return retry;
    }

}
