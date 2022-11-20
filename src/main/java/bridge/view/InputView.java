package bridge.view;

import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            new InputValidator().validateSize(input);
        } catch (IllegalArgumentException exception) {
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        String input = Console.readLine();
        try {
            new InputValidator().validateMoving(input);
        } catch (IllegalArgumentException exception) {
            return readMoving();
        }
        return Direction.valueOf(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        try {
            new InputValidator().validateGameCommand(input);
        } catch (IllegalArgumentException exception) {
            return readGameCommand();
        }
        return input;
    }
}
