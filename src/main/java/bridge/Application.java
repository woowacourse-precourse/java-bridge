package bridge;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        bridgeGame = BridgeGame.getInstance();

        int bridgeSize = initGame();
        startGame(bridgeSize);
        printResult();
    }

    private static int initGame() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.init(bridgeSize);
        return bridgeSize;
    }

    private static void startGame(int bridgeSize) {
        do {
            startRound(bridgeSize);
        } while (!bridgeGame.isSuccess() && bridgeGame.retry(inputView.readGameCommand()));
    }

    private static void startRound(int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            boolean isMove = bridgeGame.move(inputView.readMoving(), i);
            outputView.printMap(bridgeGame.bridgeMapToString());

            if (!isMove) {
                break;
            }
        }
    }

    private static void printResult() {
        outputView.printResult(bridgeGame.gameResultToString());
    }
}
