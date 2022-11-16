package bridge.view;

import java.util.List;

public class OutputView {
    private static String upBridge = "[]";
    private static String downBridge = "[]";

    public void start() {
        System.out.println(OutputString.START.getPrint());
        System.out.println(OutputString.INPUT.getPrint());
    }

    public void choice() {
        System.out.println(OutputString.MOVE.getPrint());
    }

    public void printMap(String input, boolean tf, int idx) {
        if (tf == true) {
            printTrue(input);
            if (idx == 0) {
                upBridge = upBridge.replace("|", "");
                downBridge = downBridge.replace("|", "");
            }
            return;
        }
        printFalse(input);
        if (idx == 0) {
            upBridge = upBridge.replace("|", "");
            downBridge = downBridge.replace("|", "");
        }
    }

    public void printTrue(String input) {
        if (input.equals("U")) {
            upBridge = upBridge.replace("]", "| O ]");
            downBridge = downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge = upBridge.replace("]", "|   ]");
            downBridge = downBridge.replace("]", "| O ]");
            return;
        }
    }

    public void printFalse(String input) {
        if (input.equals("U")) {
            upBridge = upBridge.replace("]", "| O ]");
            downBridge = downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge = upBridge.replace("]", "|   ]");
            downBridge = downBridge.replace("]", "| X ]");
            return;
        }
    }

    public void printMove() {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public void lastPrint() {
        System.out.println();
        System.out.println(OutputString.LAST.getPrint());
        System.out.println(upBridge);
        System.out.println(downBridge);
        System.out.println();
    }

    public void printResult(boolean tf, int count) {
        lastPrint();
        if (!tf) {
            System.out.print(OutputString.RESULT.getPrint());
            System.out.println(OutputString.FAIL.getPrint());
            System.out.print(OutputString.TRY.getPrint());
            System.out.println(count);
            return;
        }
        System.out.print(OutputString.RESULT.getPrint());
        System.out.println(OutputString.SUCCESS.getPrint());
        System.out.print(OutputString.TRY.getPrint());
        System.out.println(count);
    }

    public void retry() {
        System.out.println(OutputString.RETRY.getPrint());
    }
}
