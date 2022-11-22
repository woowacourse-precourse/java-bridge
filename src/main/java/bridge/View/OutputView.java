package bridge.View;

import bridge.Constant.Message;

public class OutputView {

    public void printMap() {
    }

    public void printResult() {
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
}
