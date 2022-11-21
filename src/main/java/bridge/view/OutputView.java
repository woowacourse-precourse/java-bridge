package bridge.view;

import bridge.Application;
import bridge.BridgeGame;
import bridge.OutputConstants;

public class OutputView {

    public static void printMap() {
        BridgeGame.upSide.makeUpSide();
        System.out.println(BridgeGame.upSide.getUpSide());
        BridgeGame.downSide.makeDownSide();
        System.out.println(BridgeGame.downSide.getDownSide());
        System.out.println();
    }

    public static void printResult() {
        System.out.println(OutputConstants.RESULT);
        printMap();
        printSuccess();
        System.out.println(OutputConstants.TOTAL_TRY + BridgeGame.totalTrial);
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
}
