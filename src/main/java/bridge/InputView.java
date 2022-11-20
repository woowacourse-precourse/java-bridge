package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String userInput = Console.readLine();

        try {
            Validation.validateBridgeSize(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            readBridgeSize();
        }
        return Integer.parseInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userInput = Console.readLine();

        try {
            Validation.validateMovingChoice(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            readMoving();
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
