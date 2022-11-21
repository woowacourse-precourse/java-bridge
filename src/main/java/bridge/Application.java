package bridge;

import constant.Values.MoveCase;

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
        boolean isContinue=true;
        isContinue=checker.checkBridgeGameResult(bridgeGame);
        if(!isContinue){
            isContinue=inputRetry();
        }
        if(isContinue){
            bridgeGameContinue(bridgeGame);
        }
    }

    private void outputMove(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame);
    }

    private boolean inputRetry() {
        outputView.printSelectRetry();
        return checker.checkRetry(inputView.readGameCommand());
    }
}
