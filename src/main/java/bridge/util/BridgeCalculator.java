package bridge.util;

import bridge.constant.GameProgressKeyword;
import bridge.constant.MessageOutput;

public class BridgeCalculator {
    public static String calculateSuccessOrFail(boolean isSuccess) {
        if(isSuccess) {
            return MessageOutput.SUCCESS;
        }
        return MessageOutput.FAIL;
    }
}
