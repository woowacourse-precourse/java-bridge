package bridge.view;

import java.util.List;

public class OutputView {
    private static String upBridge = "[]";
    private static String downBridge = "[]";

    public void start() {
        System.out.println(OutputString.START);
        System.out.println(OutputString.INPUT);
    }

    public void choice() {
        System.out.println(OutputString.MOVE);
    }

    public void printMap(String input, boolean tf, int idx) {
        if (tf == true) {
            printTrue(input);
            if (idx == 0)
                input.replace("|", "");
            return;
        }
        printFalse(input);
        if (idx == 0)
            input.replace("|", "");
    }

    public void printTrue(String input) {
        if (input.equals("U")) {
            upBridge.replace("]", "| O ]");
            downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge.replace("]", "|   ]");
            downBridge.replace("]", "| O ]");
            return;
        }
    }

    public void printFalse(String input) {
        if (input.equals("U")) {
            upBridge.replace("]", "| O ]");
            downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge.replace("]", "|   ]");
            downBridge.replace("]", "| X ]");
            return;
        }
    }

    public void printMove() {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public void printResult(boolean tf, int count) {
        if (!tf) {
            System.out.print(OutputString.SUCCESS_OR_NOT);
            System.out.println(OutputString.FAIL);
            System.out.print(OutputString.TRY );
            System.out.println(count);
            return;
        }
        System.out.print(OutputString.SUCCESS_OR_NOT);
        System.out.println(OutputString.SUCCESS);
        System.out.print(OutputString.TRY );
        System.out.println(count);
    }

    public void retry() {
        System.out.println(OutputString.RETRY);
    }
}
