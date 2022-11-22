package bridge.domain;

import bridge.data.constant.OutputConstants;
import bridge.view.InputView;
import bridge.view.OutputView;

public class StartGame {
    public static String movingInput;

    public static boolean startGame(BridgeGame bridgeGame) {
        requestMove();
        bridgeGame.move();
        OutputView.printMap(bridgeGame);
        if (bridgeGame.isWrongWay()) {
            return chooseWhenWrong(bridgeGame);
        }
        bridgeGame.movingTurn++;
        return true;
    }

    public static void requestMove() {
        OutputView.printSelect();
        movingInput = InputView.readMoving();
    }

    public static boolean chooseWhenWrong(BridgeGame bridgeGame) {
        if (wantRetry()) {
            bridgeGame.retry();
            return true;
        }
        bridgeGame.success = false;
        return false;
    }

    public static boolean wantRetry() {
        OutputView.printRetry();
        return InputView.readGameCommand().equals(OutputConstants.RETRY);
    }
}
