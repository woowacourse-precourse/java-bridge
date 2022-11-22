package bridge.view;

import bridge.domain.MoveDirection;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        this.validateParseStringToInteger(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveDirection readMoving() {
        String input = Console.readLine();
        return new MoveDirection(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }

    private void validateParseStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }
}
