package bridge.util;

import bridge.constant.BridgeStructure;
import bridge.constant.ErrorOutput;

import static bridge.util.InputValidator.*;

public class BridgeValidator {
    public static boolean possibleBridgeSize(String input) {
        if(isNumber(input) && isInteger(input)) {
            int num = Integer.parseInt(input);
            if (num < BridgeStructure.MIN_BRIDGE_SIZE || num > BridgeStructure.MAX_BRIDGE_SIZE) {
                System.out.println(ErrorOutput.WRONG_BRIDGE_SIZE);
                throw new IllegalArgumentException(ErrorOutput.WRONG_BRIDGE_SIZE);
            }
        }
        return true;
    }

    public static boolean possibleMovingSelect(String select) {
        // constant로 대체
        if(!select.equals("U") && !select.equals("D")) {
            System.out.println(ErrorOutput.WRONG_SPACE_TO_MOVE_CHARACTER);
            throw new IllegalArgumentException(ErrorOutput.WRONG_SPACE_TO_MOVE_CHARACTER);
        }

        return true;
    }

    public static boolean possibleRetryDecision(String decision) {
        // constant로 대체
        if(!decision.equals("R") && !decision.equals("Q")) {
            System.out.println(ErrorOutput.WRONG_RETRY_OR_QUIT_CHARACTER);
            throw new IllegalArgumentException(ErrorOutput.WRONG_RETRY_OR_QUIT_CHARACTER);
        }

        return true;
    }
}
