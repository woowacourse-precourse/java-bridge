package bridge.View;

import bridge.Constant.Message;
import bridge.Model.BridgeMap;

public class OutputView {

    public static void printInit() {
        System.out.println(Message.START.print());
    }

    public static void printError(String error) {
        System.out.println(error);
    }

    public static void printMove() {
        System.out.println(Message.MOVE.print());
    }

    public static void printMap(BridgeMap bridgeMap) {
        System.out.print(bridgeMap+"\n");
    }
}
