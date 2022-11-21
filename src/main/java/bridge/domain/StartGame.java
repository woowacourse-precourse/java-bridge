package bridge.domain;

import bridge.Application;
import bridge.data.constant.OutputConstants;
import bridge.view.InputView;
import bridge.view.OutputView;

public class StartGame {
    public static int totalTrial = 1;
    public static String movingInput;

    public static boolean startGame(BridgeGame bridgeGame) {
        requestMove();
        bridgeGame.move();
        OutputView.printMap(bridgeGame);
        if (isWrongWay()) {
            return chooseWhenWrong(bridgeGame);
        }
        Application.movingTurn++;
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

    public static boolean isRightWay() {
        String rightWay = Application.bridge.get(Application.movingTurn);
        return rightWay.equals(movingInput);
    }

    public static boolean isWrongWay() {
        return !isRightWay();
    }
}
