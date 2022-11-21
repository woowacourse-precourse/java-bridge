package bridge.domain;

import bridge.Application;
import bridge.data.constant.OutputConstants;
import bridge.view.InputView;
import bridge.view.OutputView;

public class StartGame {
    public static int totalTrial;
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
        Application.success = false;
        return false;
    }

    public static boolean wantRetry() {
        OutputView.printRetry();
        String retryOrNot = InputView.readGameCommand();
        return retryOrNot.equals(OutputConstants.RETRY);
    }
}
