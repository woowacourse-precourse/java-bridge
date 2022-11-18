package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_PHRASE = "다리의 길이를 입력해주세요.";
    private static final String INVALID_CANT_CONVERT_INTEGER = "[ERROR] 숫자가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_PHRASE);
        String userInputLengthOfBridge = Console.readLine();
        return validateBridgeSize(userInputLengthOfBridge);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static int validateBridgeSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_CANT_CONVERT_INTEGER);
        }
    }
}
