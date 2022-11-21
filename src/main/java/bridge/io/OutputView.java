package bridge.io;

import bridge.game.BridgeGame;
import bridge.model.Model;

public class OutputView {

    public static void printMap() {
        printCurrentUpperBridgeState();
        printCurrentLowerBridgeState();
        System.out.println();
    }
    private static void printCurrentUpperBridgeState() {
        String step1 = replaceCommaToBar(Model.upperBridgeMap.toString());
        String step2 = extractInBracket(step1);
        System.out.println("[ " + step2 + " ]");
    }
    private static void printCurrentLowerBridgeState() {
        String step1 = replaceCommaToBar(Model.lowerBridgeMap.toString());
        String step2 = extractInBracket(step1);
        System.out.println("[ " + step2 + " ]");
    }
    private static String replaceCommaToBar(String string) {
        return string.replace(",", " |");
    }
    private static String extractInBracket(String string) {
        return string.substring(1,string.length()-1);
    }


    public static void printResult() {
        System.out.println(IO_msg.OUTPUT_GAME_RESULT.msg);
        printMap();
        System.out.println(IO_msg.OUTPUT_PASS_FAIL.msg + printGameResult());
        System.out.println(IO_msg.OUTPUT_TOTAL_TRY_COUNT.msg + BridgeGame.tryCount);
    }
    private static String printGameResult() {
        int lastIndexOfBridge = Model.upperBridgeMap.size()-1;
        String upperLast = Model.upperBridgeMap.get(lastIndexOfBridge);
        String lowerLast = Model.lowerBridgeMap.get(lastIndexOfBridge);
        if (upperLast.equals("O") || lowerLast.equals("O")) {
            return IO_msg.RESULT_SCECESS.msg;
        }
        return IO_msg.RESULT_FAIL.msg;
    }
}
