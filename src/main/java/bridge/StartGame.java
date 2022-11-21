package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class StartGame {

    public static String movingInput;

    public static boolean startGame() {
        requestMove();
        BridgeGame.move();
        OutputView.printMap();
        if (isWrongWay()) {
            return whenWrong();
        }
        Application.movingTurn++;
        return true;
    }

    public static void requestMove() {
        OutputView.printSelect();
        movingInput = InputView.readMoving();
    }

    public static boolean whenWrong() {
        if (wantRetry()) {
            BridgeGame.retry();
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
