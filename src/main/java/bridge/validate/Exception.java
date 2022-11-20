package bridge.validate;

import bridge.ErrorMessage;

public class Exception {

    private void validateThreeToTwenty(int bridgeCount) {
        if (bridgeCount < 3 || bridgeCount > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_THREE_TO_TWENTY.getErrorMessage());
        }
    }

    private void validateUpOrDown(String moveBridgeSpace) {
        if (!moveBridgeSpace.equals("U") && !moveBridgeSpace.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_BRIDGE_SPACE_IS_U_OR_D.getErrorMessage());
        }
    }

    private void validateRetryOrQuit(String retryAnswer) {
        if (!retryAnswer.equals("R") && !retryAnswer.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_ANSWER_IS_R_OR_Q.getErrorMessage());
        }
    }
}
