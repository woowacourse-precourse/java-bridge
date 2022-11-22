package bridge.Validate;

import bridge.Exception.ErrorType;
import bridge.OutputView;

public class ValidateInput {
    OutputView outputView = new OutputView();

    public void isInputSizeOneOrTwo(String bridgeSizeInput) {
        if (bridgeSizeInput == null || bridgeSizeInput.length() >= 3) {
            outputView.printException(ErrorType.IS_THREE_TO_TWENTY);
            throw new IllegalArgumentException();
        }
    }

    public void isNumber(String bridgeSizeInput) {
        char[] inputs = bridgeSizeInput.toCharArray();

        for (char input : inputs) {
            if (input < '0' || input > '9') {
                outputView.printException(ErrorType.IS_THREE_TO_TWENTY);
                throw new IllegalArgumentException();
            }
        }
    }

    public void isNumberThreeToTwenty(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            outputView.printException(ErrorType.IS_THREE_TO_TWENTY);
            throw new IllegalArgumentException();
        }
    }

    public void isInputSizeOne(String movingInput) {
        if (movingInput == null || movingInput.length() >= 2) {
            outputView.printException(ErrorType.IS_UP_OR_DOWN);
            throw new IllegalArgumentException();
        }
    }

    public void isUpOrDown(String movingInput) {
        char input = movingInput.charAt(0);

        if (input != 'U' && input != 'D') {
            outputView.printException(ErrorType.IS_UP_OR_DOWN);
            throw new IllegalArgumentException();
        }
    }
}
