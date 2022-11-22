package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String PRINT_INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_INPUT_MOVING_INFORMATION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println(System.lineSeparator() + PRINT_INPUT_BRIDGE_LENGTH_MESSAGE);
        // 입력 받기
        return Console.readLine();
    }

    /**
     * 다리 길이 입력이 숫자인지 검증
     */
    public static void validateBridgeLength(String bridgeLength) {
        String numberExpression = "^[0-9]+$";

        if (!bridgeLength.matches(numberExpression) ||
                (bridgeLength.length() >= 2 && bridgeLength.charAt(0) == '0')) {
            throw new IllegalArgumentException(Error.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    /**
     * 다리 길이의 유효성 검증
     */
    public static void validateBridgeLengthRange(int bridgeLength) {
        if (!(3 <= bridgeLength && bridgeLength <= 20)) {
            throw new IllegalArgumentException(Error.INPUT_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(PRINT_INPUT_MOVING_INFORMATION);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
