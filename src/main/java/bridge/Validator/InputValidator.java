package bridge.Validator;

import bridge.status.ExceptionStatus;
import bridge.view.OutputView;

public class InputValidator {

    public static String checkBridgeSize(String size) {
        try {
            checkOnlyNumber(size);
            checkBoundaryNumber(size);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return "error";
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
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_BOUNDARY.getException());
        }
    }

    public static String controlMovingInput(String moving) {
        try {
            checkMoving(moving);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return "error";
        }
        return moving;
    }

    public static void checkMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_INPUT.getException());
        }
    }

    public static String controlRetryInput(String retryInput) {
        try {
            checkRetry(retryInput);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return "error";
        }
        return retryInput;
    }

    public static void checkRetry(String retryInput) {
        if (!(retryInput.equals("Q") || retryInput.equals("R"))) {
            throw new IllegalArgumentException(ExceptionStatus.INVALID_INPUT.getException());
        }
    }
}
