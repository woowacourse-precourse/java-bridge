package userdomain.operator;

import userdomain.userinterface.Message;

public class UserException {

    public boolean checkUserMove(String userMove) {
        try {
            checkMoveInputSize(userMove);
            checkMoveInputRange(userMove);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void checkMoveInputRange(String userMove) {
        if (!(userMove.contains("U") || userMove.contains("D"))) {
            throw new IllegalArgumentException(Message.USER_MOVE_INPUT_ERROR.getMessage());
        }
    }
    public void checkMoveInputSize(String userMove) {
        if (userMove.length() != 1) {
            throw new IllegalArgumentException(Message.USER_MOVE_INPUT_SIZE_ERROR.getMessage());
        }
    }

    public boolean checkRetry(String retry) {
        try {
            checkRetryInputRange(retry);
            checkRetryInputSize(retry);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void checkRetryInputSize(String retry) {
        if (retry.length() != 1) {
            throw new IllegalArgumentException(Message.USER_RETRY_INPUT_SIZE_ERROR.getMessage());
        }
    }

    public void checkRetryInputRange(String retry) {
        if (!(retry.contains("R") || retry.contains("Q"))) {
            throw new IllegalArgumentException(Message.USER_RETRY_INPUT_RANGE_ERROR.getMessage());
        }
    }

    public boolean checkBridgeSize(String bridgeSize) {
        try {
            checkBridgeSizeRange(bridgeSize);
            checkBridgeSizeInput(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void checkBridgeSizeRange(String bridgeSize) {
        for (int i = 0; i < bridgeSize.length(); i++) {
            if (i == 0 && bridgeSize.charAt(i) == '0') {
                throw new IllegalArgumentException(Message.BRIDGE_SIZE_INPUT_ZERO_ERROR.getMessage());
            }
            if (!(bridgeSize.charAt(i) >= '0' && bridgeSize.charAt(i) <= '9')) {
                throw new IllegalArgumentException(Message.BRIDGE_SIZE_INPUT_ERROR.getMessage());
            }
        }
    }

    public void checkBridgeSizeInput(String bridgeSize) {
        if (!(Integer.valueOf(bridgeSize) >= 3 && Integer.valueOf(bridgeSize) <= 20)) {
            throw new IllegalArgumentException(Message.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

}
