package bridge.view;

import bridge.type.ErrorType;
import bridge.type.TextType;
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

        int size = parseNumber(input);
        validateSize(size);

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();

        validateMoving(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();

        validateCommand(input);

        return input;
    }

    public int parseNumber(String input) {
        boolean isNumeric = input.chars().allMatch(Character::isDigit);

        if (!isNumeric) throw new IllegalArgumentException(ErrorType.NOT_NUMBER_INPUT.getError());

        return Integer.parseInt(input);
    }

    public void validateSize(int size) {
        if (size < 3 || size > 20) throw new IllegalArgumentException(ErrorType.OVER_SIZE.getError());
    }

    public void validateMoving(String input) {
        if (!input.equals(TextType.UP.getText()) && !input.equals(TextType.DOWN.getText()))
                throw new IllegalArgumentException(ErrorType.NOT_MOVING_INPUT.getError());
    }

    public void validateCommand(String input) {
        if (!input.equals(TextType.RESTART.getText()) && !input.equals(TextType.EXIT.getText()))
                throw new IllegalArgumentException(ErrorType.NOT_COMMAND_INPUT.getError());
    }
}
