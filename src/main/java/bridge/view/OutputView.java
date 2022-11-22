package bridge.view;

import bridge.Application;
import bridge.domain.BridgeGame;
import bridge.data.constant.OutputConstants;

public class OutputView {

    public static void printMap(BridgeGame bridgeGame) {
        bridgeGame.upSide.makeUpSide();
        System.out.println(bridgeGame.upSide.getUpSide());
        bridgeGame.downSide.makeDownSide();
        System.out.println(bridgeGame.downSide.getDownSide());
        System.out.println();
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(OutputConstants.RESULT);
        printMap(bridgeGame);
        printSuccess(bridgeGame);
        System.out.println(OutputConstants.TOTAL_TRY + Application.totalTrial);
    }

    public static void printSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.finish) {
            System.out.println(OutputConstants.SUCCESS);
            return;
        }
        System.out.println(OutputConstants.FAIL);
    }

    public static void printStart() {
        System.out.println(OutputConstants.START);
        System.out.println();
    }

    public static void printRequestSize() {
        System.out.println(OutputConstants.SIZE_REQUEST);
    }

    public static void printSelect() {
        System.out.println(OutputConstants.MOVE_REQUEST);
    }

    public static void printRetry() {
        System.out.println(OutputConstants.RETRY_REQUEST);
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e);
    }
}
