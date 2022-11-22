package bridge.Validator;

import bridge.status.RetryStatus;
import bridge.status.BoundaryStatus;
import bridge.status.CommentStatus;
import bridge.status.ExceptionStatus;
import bridge.status.PositionStatus;
import bridge.view.OutputView;

public class InputValidator {

    public static String checkBridgeSize(String size) {
        try {
            checkOnlyNumber(size);
            checkBoundaryNumber(size);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return CommentStatus.ERROR.getText();
        }
        return size;
    }

    public static void checkOnlyNumber(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionStatus.IS_NOT_NUMBER.getException());
        }
    }

    public static void checkBoundaryNumber(String size) {
        Integer bridgeSize = Integer.parseInt(size);
        if (bridgeSize < BoundaryStatus.MIN_LENGTH.getLength() || bridgeSize > BoundaryStatus.MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_BOUNDARY.getException());
        }
    }

    public static String controlMovingInput(String moving) {
        try {
            checkMoving(moving);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return CommentStatus.ERROR.getText();
        }
        return moving;
    }

    public static void checkMoving(String moving) {
        if (!(moving.equals(PositionStatus.UP.getText()) || moving.equals(PositionStatus.DOWN.getText()))) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_INPUT.getException());
        }
    }

    public static String controlRetryInput(String retryInput) {
        try {
            checkRetry(retryInput);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return CommentStatus.ERROR.getText();
        }
        return retryInput;
    }

    public static void checkRetry(String retryInput) {
        if (!(retryInput.equals(RetryStatus.EXIT.getText()) || retryInput.equals(RetryStatus.RETRY.getText()))) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_INPUT.getException());
        }
    }
}
