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
}
