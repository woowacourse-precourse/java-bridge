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
        int bridgeSize;

        try {
            Validation.validateBridgeSize(userInput);
            bridgeSize = Integer.parseInt(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userInput = Console.readLine();

        try {
            Validation.validateMovingChoice(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            userInput = readMoving();
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String userInput = Console.readLine();

        try {
            Validation.validateGameCommand(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            userInput = readGameCommand();
        }
        return userInput;
    }
}
