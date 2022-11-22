package bridge.utils;

public class UserInputException {

    public static void checkUserInputBridgeSize(String userInput) {
        isNumber(userInput);
        isValidRange(userInput);
    }

    public static void isNumber(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                throw new IllegalArgumentException("[ERROR] 다리길이는 숫자로 이루어져야 합니다.");
            }
        }
    }

    public static void isValidRange(String userInput) {
        int userInputAsInteger = Integer.parseInt(userInput);
        if ((userInputAsInteger < 3) || (userInputAsInteger > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
        }
    }

    public static void isCorrectMovingCommand(String userInput) {
        if (!(userInput.equals(Constant.UPPER.getValue())) && !(userInput.equals(
                Constant.DOWN.getValue()))) {
            throw new IllegalArgumentException("[ERROR] 이동하기 위해서는 U 또는 D를 입력해야 합니다.");
        }
    }

    public static void isCorrectGameCommand(String userInput) {
        if (!(userInput.equals(Constant.RETRY.getValue())) && !(userInput.equals(
                Constant.QUIT.getValue()))) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 R 또는 Q를 입력해야 합니다.");
        }
    }

}
