package bridge.domain;

import java.util.List;

public class CalculationResult {

    private static String RIGHT = "O";
    private static String WRONG = "X";
    private static String NOT_MATCH = " ";

    public static String calculateUpper(String bridgeKeyword, String userKeyword) {
        if (bridgeKeyword == "U" && bridgeKeyword == userKeyword) {
            return RIGHT;
        }
        if (bridgeKeyword == "U" && bridgeKeyword != userKeyword) {
            return WRONG;
        }
        return NOT_MATCH;
    }

    public static String calculateLower(String bridgeKeyword, String userKeyword) {
        if (bridgeKeyword == "D" && bridgeKeyword == userKeyword) {
            return RIGHT;
        }
        if (bridgeKeyword == "D" && bridgeKeyword != userKeyword) {
            return WRONG;
        }
        return NOT_MATCH;
    }

    public static boolean calculateResult() {
        List<String> bridge = Bridge.getBridge();
        List<String> userInputBridge = User.getUserMovingRecord();
        return bridge.equals(userInputBridge);
    }
}
