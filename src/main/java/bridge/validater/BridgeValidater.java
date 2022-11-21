package bridge.validater;

import bridge.constant.GameProgressKeyword;

public class BridgeValidater {
    public static boolean compareInputAndResult(String input, String result) {
        if(input.equals(result)) {
            return true;
        }
        return false;
    }

    public static boolean whetherRetryOrQuit(String decision) {
        if(decision.equals(GameProgressKeyword.RETRY_GAME)) {
            return true;
        }
        return false;
    }
}
