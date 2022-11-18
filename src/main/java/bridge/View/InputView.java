package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_PHRASE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_BRIDGE_PHRASE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INVALID_CANT_CONVERT_INTEGER = "[ERROR] 숫자가 아닙니다.";
    private static final String INVALID_RANGE = "[ERROR] 3 이상 20 이하 숫자를 입력해주세요.";
    private static final String INVALID_VALUE = "[ERROR] U나 D를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_PHRASE);
        String userInputLengthOfBridge = Console.readLine();
        return validateBridgeLength(userInputLengthOfBridge);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(MOVING_BRIDGE_PHRASE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static int validateBridgeLength(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_CANT_CONVERT_INTEGER);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private static String validateIsUOrD() {
        try {
            return Console.readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
    }
}
