package bridge.domain;

import java.util.List;

public class CalculationResult {

    private static String RIGHT = "O";
    private static String WRONG = "X";
    private static String NOT_MATCH = " ";

    public static String calculateUpper(String bridgeKeyword, String userKeyword) {
        if (userKeyword.equals("U") && bridgeKeyword.equals(userKeyword)) {
            return RIGHT;
        }
        if (userKeyword.equals("U") && !bridgeKeyword.equals(userKeyword)) {
            return WRONG;
        }
        return NOT_MATCH;
    }

    public static String calculateLower(String bridgeKeyword, String userKeyword) {
        if (userKeyword.equals("D") && bridgeKeyword.equals(userKeyword)) {
            return RIGHT;
        }
        if (userKeyword.equals("D") && !bridgeKeyword.equals(userKeyword)) {
            return WRONG;
        }
        return NOT_MATCH;
    }

    public static boolean calculateResult() {
        List<String> bridge = Bridge.getBridge();
        List<String> userInputBridge = User.getUserMovingRecord();
        for (int i = 0; i < userInputBridge.size(); i++) {
            if (!bridge.get(i).equals(userInputBridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean calculateFinalResult() {
        List<String> bridge = Bridge.getBridge();
        List<String> userInputBridge = User.getUserMovingRecord();
        return bridge.equals(userInputBridge);
    }
}
