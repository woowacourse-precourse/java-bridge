package bridge.View;

import bridge.Constant.Message;
import bridge.Model.BridgeMap;

public class OutputView {

    public static void printMap(final BridgeMap bridgeMap) {
        System.out.print(bridgeMap + "\n");
    }

    public static void printResult(final int playCount, final boolean isWinner) {
        if (isWinner) {
            System.out.println(Message.GAME_STATE.print() + Message.WIN.print());
        }
        if (!isWinner) {
            System.out.println(Message.GAME_STATE.print() + Message.LOSE.print());
        }
        System.out.println(Message.COUNT.print() + playCount);
    }

    public static void printInit() {
        System.out.println(Message.START.print());
    }

    public static void printError(String error) {
        System.out.println(error);
    }

    public static void printMove() {
        System.out.println(Message.MOVE.print());
    }

    public static void printStartOrEnd() {
        System.out.println(Message.START_OR_END.print());
    }

    public static void printEndGame() {
        System.out.println(Message.RESULT.print());
    }
}
