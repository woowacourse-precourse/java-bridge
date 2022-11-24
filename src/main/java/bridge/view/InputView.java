package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String SELECT_DIRECTION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String SELECT_RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getInputWithMessage(BRIDGE_SIZE_MESSAGE);
        return convertToNumber(input);
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return getInputWithMessage(SELECT_DIRECTION_MESSAGE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return getInputWithMessage(SELECT_RETRY_MESSAGE);
    }

    private String getInputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
