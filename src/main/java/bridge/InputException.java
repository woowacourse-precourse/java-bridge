package bridge;

public class InputException {

    public void validateReadBridgeSize(String inputNumber) {
        if (!isNumber(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다. 프로그램을 종료합니다.");
        }

        if (!isRangeThreeToTwenty(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어 난 값을 입력했습니다. 프로그램을 종료합니다.");
        }
    }

    public void validateReadMoving(String inputNumber) {
        if (!isLengthOne(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 값을 입력했습니다. 프로그램을 종료합니다.");
        }

        if (!isInputPositionRight(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 값을 입력했습니다. 프로그램을 종료합니다.");
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
}
