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
            int size = Integer.parseUnsignedInt(Console.readLine());
            validateSize(size);
            return size;
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(InputError.INVALID_SIZE.getMessage());
        }
    }

    private void validateSize(int size) {
        if(size < 3 || size > 20){
            throw new IllegalArgumentException();
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
