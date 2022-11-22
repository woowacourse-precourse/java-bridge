package bridge;

import bridge.enums.ErrorMessage;

public class InputException {

    public void validateReadBridgeSize(String inputNumber) {
        if (!isNumber(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }

        if (!isRangeThreeToTwenty(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    public void validateReadMoving(String inputNumber) {
        if (!isLengthOne(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }

        if (!isInputPositionRight(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    public void validateReadGameCommand(String inputCommand) {
        if (!isLengthOne(inputCommand)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }

        if (!isInputCommandRight(inputCommand)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    public boolean isNumber(String inputNumber) {
        for (char number : inputNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }

    public boolean isRangeThreeToTwenty(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number >= 3 && number <= 20) {
            return true;
        }
        return false;
    }

    public boolean isLengthOne(String inputPosition) {
        if (inputPosition.length() == 1) {
            return true;
        }
        return false;
    }

    public boolean isInputPositionRight(String inputPosition) {
        if (inputPosition.equals("U") || inputPosition.equals("D")) {
            return true;
        }
        return false;
    }

    public boolean isInputCommandRight(String inputCommand) {
        if (inputCommand.equals("R") || inputCommand.equals("Q")) {
            return true;
        }
        return false;
    }
}
