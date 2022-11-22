package bridge.view;

import bridge.error.InputError;
import bridge.model.Command;
import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            return Integer.parseUnsignedInt(Console.readLine());
        } catch (NumberFormatException iae) {
            throw new IllegalArgumentException(InputError.NOT_UNSIGNED_INT.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        try {
            return Direction.fromSymbol(Console.readLine());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(InputError.INVALID_DIRECTION_SYMBOL.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        try {
            return Command.fromSymbol(Console.readLine());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(InputError.INVALID_COMMAND_SYMBOL.getMessage());
        }
    }
}
