package bridge;

import static bridge.Application.movingInput;

public class StartGame {

    public static boolean startGame() {
        OutputView.printSelect();
        movingInput = InputView.readMoving();
        BridgeGame.move();
        OutputView.printMap();
        if (isWrong()) {
            if (wantRetry()) {
                BridgeGame.retry();
                return true;
            }
            return false;
        }
        Application.movingTurn++;
        return true;
    }

    public static boolean wantRetry() {
        OutputView.printRetry();
        String retryOrNot = InputView.readGameCommand();
        if (retryOrNot.equals("R"))
            return true;
        return false;
    }

    public static boolean isRightWay() {
        String rightWay = Application.bridge.get(Application.movingTurn);
        boolean isRightAnswer = rightWay.equals(Application.movingInput);
        return isRightAnswer;
    }

    public static boolean isWrong() {
        boolean isWrongWay = !isRightWay();
        return isWrongWay;
    }
}
