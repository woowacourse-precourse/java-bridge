package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        new Application().play();
    }

    private void play() {
        outputView.printStart();
        bridgeGame = bridgeGameStart();
        bridgeGame.move(inputSelectMove());
    }

    private BridgeGame bridgeGameStart() {
        int bridgeSize = inputBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        return bridgeGame;
    }

    private int inputBridgeSize() {
        outputView.printInputSize();
        int bridgeSize;
        try {
            bridgeSize=inputView.readBridgeSize();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);
            bridgeSize=inputBridgeSize();
        }
        return bridgeSize;
    }

    private String inputSelectMove() {
        outputView.printSelectMove();
        String selectMove;
        try {
            selectMove=inputView.readMoving();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);
            selectMove=inputSelectMove();
        }
        return selectMove;
    }
}
