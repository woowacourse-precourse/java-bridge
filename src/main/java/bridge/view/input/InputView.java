package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.Constants.BRIDGE_ARROW_VALUE_LENGTH;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validateMovingValueLength(moving);
        return moving;
    }

    private void validateMovingValueLength(String moving) {
        if (moving.length() > BRIDGE_ARROW_VALUE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
