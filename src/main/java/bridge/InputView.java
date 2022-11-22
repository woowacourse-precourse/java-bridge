package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readLine();
        return validateBridgeSize(userInput);
    }

    private int validateBridgeSize(String userInput) {
        Validator.isIntegerValue(userInput);
        int size = Integer.parseInt(userInput);
        Validator.isInRangeValue(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = readLine();
        return validateMoving(userInput);
    }

    private String validateMoving(String userInput) {
        Validator.isMovingCommand(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = readLine();
        return validateGameCommand(userInput);
    }

    private String validateGameCommand(String userInput) {
        Validator.isGameCommand(userInput);
        return userInput;
    }
}
