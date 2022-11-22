package bridge.view;

import static bridge.constant.ExceptionMessage.*;
import static bridge.constant.RequestMessage.*;
import static bridge.view.OutputView.printExceptionMessage;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE_MESSAGE);
        try {
            int size = Integer.parseInt(Console.readLine());
            validateLength(size);
            return size;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println(CHOOSE_MOVE_BRIDGE_MESSAGE);
        try {
            return Direction.from(Console.readLine());
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(RETRY_STATUS_MESSAGE);
        try {
            return GameCommand.from(Console.readLine());
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return readGameCommand();
        }
    }

    private void validateLength(int length) {
        if (length < MIN_BRIDGE_LENGTH || MAX_BRIDGE_LENGTH < length) {
            throw new IllegalArgumentException(BRIDGE_SIZE_EXCEPTION_MESSAGE);
        }
    }

}
