package bridge.domain;

import bridge.utils.Constant;
import java.util.List;

public class CalculationResult {

    public static String calculateUpper(String bridgeKeyword, String userKeyword) {
        if (userKeyword.equals(Constant.UPPER.getValue()) && bridgeKeyword.equals(userKeyword)) {
            return Constant.RIGHT.getValue();
        }
        if (userKeyword.equals(Constant.UPPER.getValue()) && !bridgeKeyword.equals(userKeyword)) {
            return Constant.WRONG.getValue();
        }
        return Constant.NOT_MATCH.getValue();
    }

    public static String calculateLower(String bridgeKeyword, String userKeyword) {
        if (userKeyword.equals(Constant.DOWN.getValue()) && bridgeKeyword.equals(userKeyword)) {
            return Constant.RIGHT.getValue();
        }
        if (userKeyword.equals(Constant.DOWN.getValue()) && !bridgeKeyword.equals(userKeyword)) {
            return Constant.WRONG.getValue();
        }
        return Constant.NOT_MATCH.getValue();
    }

    public static boolean calculateResult() {
        List<String> bridge = Bridge.getBridge();
        List<String> userInputBridge = User.getUserMovingRecord();
        for (int stage = 0; stage < userInputBridge.size(); stage++) {
            if (!bridge.get(stage).equals(userInputBridge.get(stage))) {
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
