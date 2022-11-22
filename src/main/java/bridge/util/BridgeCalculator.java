package bridge.util;

import bridge.constant.GameProgressKeyword;
import bridge.constant.MessageOutput;

public class BridgeCalculator {
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

    public static String calculateSuccessOrFail(boolean isSuccess) {
        if(isSuccess) {
            return MessageOutput.SUCCESS;
        }
        return MessageOutput.FAIL;
    }
}
