package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Checker checker = new Checker();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        new Application().play();
    }

    private void play() {
        outputView.printStart();
        bridgeGame = bridgeGameStart();
        bridgeGame.move(inputMove());
    }

    private BridgeGame bridgeGameStart() {
        int bridgeSize = inputBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        return bridgeGame;
    }

    private int inputBridgeSize() {
        outputView.printInputSize();
        int bridgeSize=-1;
        while(bridgeSize<0) {
            try {
                bridgeSize=checker.checkValidate(inputView.readBridgeSize());
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
}
