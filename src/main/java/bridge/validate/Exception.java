package bridge.validate;

import bridge.ErrorMessage;

public class Exception {

    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;

    public static void validateThreeToTwenty(int bridgeCount) {
        if (bridgeCount < MINIMUM_BRIDGE_LENGTH || bridgeCount > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_THREE_TO_TWENTY.getErrorMessage());
        }
    }

    public static void validateUpOrDown(String moveBridgeSpace) {
        if (!moveBridgeSpace.equals("U") && !moveBridgeSpace.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_BRIDGE_SPACE_IS_U_OR_D.getErrorMessage());
        }
    }

    public static void validateRetryOrQuit(String retryAnswer) {
        if (!retryAnswer.equals("R") && !retryAnswer.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_ANSWER_IS_R_OR_Q.getErrorMessage());
        }
    }
}
