package bridge.output;

import static bridge.output.OutputString.*;

public class OutputView {
    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
        System.out.println();
    }

    public static void printMap(StringBuilder upperBridge, StringBuilder lowerBridge) {
        StringBuilder upperBridgeFormat = new StringBuilder();
        StringBuilder lowerBridgeFormat = new StringBuilder();
        appendSeparator(upperBridge, lowerBridge, upperBridgeFormat, lowerBridgeFormat);
        addStartEndSign(upperBridgeFormat, lowerBridgeFormat);
        System.out.println(upperBridgeFormat);
        System.out.println(lowerBridgeFormat);
        System.out.println();
    }

    private static void addStartEndSign(StringBuilder upperBridgeFormat, StringBuilder lowerBridgeFormat) {
        upperBridgeFormat.insert(0, START_SIGN);
        lowerBridgeFormat.insert(0, START_SIGN);
        upperBridgeFormat.append(END_SIGN);
        lowerBridgeFormat.append(END_SIGN);
    }

    private static void appendSeparator(StringBuilder upperBridge, StringBuilder lowerBridge, StringBuilder upperBridgeFormat, StringBuilder lowerBridgeFormat) {
        for (int i = 0; i < upperBridge.length(); i++) {
            upperBridgeFormat.append(upperBridge.charAt(i));
            lowerBridgeFormat.append(lowerBridge.charAt(i));
            if (i != upperBridge.length() - 1) {
                upperBridgeFormat.append(SEPARATOR);
                lowerBridgeFormat.append(SEPARATOR);
            }
        }
//        for (int i = 0; i < lowerBridge.length(); i++) {
//            lowerBridgeFormat.append(lowerBridge.charAt(i));
//            if (i != lowerBridge.length() - 1) {
//                lowerBridgeFormat.append(SEPARATOR);
//            }
//        }
    }

    public static void printResult(boolean isSuccess, StringBuilder upperBridge, StringBuilder lowerBridge, int round) {
        System.out.println(FINAL_RESULT);
        printMap(upperBridge, lowerBridge);
        System.out.print(SUCCESS_OR_NOT);
        printSuccessOrNot(isSuccess, round);
    }

    private static void printSuccessOrNot(boolean isSuccess, int round) {
        if (isSuccess) {
            System.out.println(SUCCESS);
            System.out.println(ATTEMPT_COUNT + round);
            return;
        }
        System.out.println(FAIL);
        System.out.println(ATTEMPT_COUNT + round);
    }
}
