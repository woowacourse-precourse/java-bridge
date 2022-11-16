package bridge;

public class InputValidation {
    private static final String ERROR_TOKEN = "[ERROR]";

    public void bridgeSize(String userInput) {
        isNumber(userInput);
        bridgeSize(Integer.valueOf(userInput));
    }

    public void bridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_TOKEN + " 다리 길이는 3이상 20이하의 값만 입력 가능합니다.");
        }
    }

    public void userMove(String userInput) {
        if (!userInput.matches("[U|D]")) {
            throw new IllegalArgumentException(ERROR_TOKEN + " U 혹은 D 문자만 입력 가능합니다.");
        }
    }

    private void isNumber(String numberable) throws IllegalArgumentException {
        if (!numberable.matches("[0-9]*")) {
            throw new IllegalArgumentException(ERROR_TOKEN + " 다리 길이는 숫자만 입력 가능합니다.");
        }
    }
}
