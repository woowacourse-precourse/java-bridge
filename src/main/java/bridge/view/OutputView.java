package bridge.view;

import bridge.Application;
import bridge.domain.BridgeGame;
import bridge.data.constant.OutputConstants;
import bridge.domain.StartGame;

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
        printSuccess();
        System.out.println(OutputConstants.TOTAL_TRY + StartGame.totalTrial);
    }

    public static void printSuccess() {
        if (Application.success) {
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
    public static void printError(IllegalArgumentException e){
        System.out.println(e);
    }
}
