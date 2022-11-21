package bridge.io;

import bridge.game.BridgeGame;
import bridge.model.Model;

public class OutputView {

    public static void printMap() {
        String upperStep1 = replaceCommaToBar(Model.upperBridgeMap.toString());
        String upperStep2 = extractInBracket(upperStep1);
        System.out.println("[ " + upperStep2 + " ]");

        String lowerStep1 = replaceCommaToBar(Model.lowerBridgeMap.toString());
        String lowerStep2 = extractInBracket(lowerStep1);
        System.out.println("[ " + lowerStep2 + " ]");

        System.out.println();
    }
    private static String replaceCommaToBar(String string) {
        return string.replace(",", " |");
    }
    private static String extractInBracket(String string) {
        return string.substring(1,string.length()-1);
    }


    public static void printResult() {
        System.out.println(IO_message.OUTPUT_GAME_RESULT.message);
        printMap();
        System.out.println(IO_message.OUTPUT_PASS_FAIL.message + printGameResult());
        System.out.println(IO_message.OUTPUT_TOTAL_TRY_COUNT.message + BridgeGame.tryCount);
    }
    private static String printGameResult() {
        int lastIndexOfBridge = Model.upperBridgeMap.size()-1;
        String upperLast = Model.upperBridgeMap.get(lastIndexOfBridge);
        String lowerLast = Model.lowerBridgeMap.get(lastIndexOfBridge);
        if (upperLast.equals("O") || lowerLast.equals("O")) {
            return IO_message.RESULT_SCECESS.message;
        }
        return IO_message.RESULT_FAIL.message;
    }
}
