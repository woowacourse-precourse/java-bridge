package bridge.domain;

import bridge.data.constant.OutputConstants;
import bridge.view.InputView;
import bridge.view.OutputView;

public class StartGame {

    public static boolean startGame(BridgeGame bridgeGame) {
        requestMove(bridgeGame);
        bridgeGame.move();
        OutputView.printMap(bridgeGame);
        if (bridgeGame.isWrongWay()) {
            return chooseWhenWrong(bridgeGame);
        }
        return true;
    }

    public static void requestMove(BridgeGame bridgeGame) {
        OutputView.printSelect();
        bridgeGame.movingInput = InputView.readMoving();
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
