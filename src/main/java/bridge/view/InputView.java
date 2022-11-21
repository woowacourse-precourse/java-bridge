package bridge.view;

import static bridge.message.ErrorMessage.NOT_A_NUMBER;
import static bridge.message.OutputMessage.GET_BRIDGE_SIZE_COMMENT;
import static bridge.message.OutputMessage.GET_MOVE_CHOICE_COMMENT;
import static bridge.message.OutputMessage.GET_RETRY_INTENTION_COMMENT;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE_COMMENT);
        Integer integer = getInteger();
        System.out.println();

        return integer;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(GET_MOVE_CHOICE_COMMENT);
        return getString();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GET_RETRY_INTENTION_COMMENT);
        return getString();
    }

    private String getString() {
        return Console.readLine();
    }

    private int getInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.get());
        }
    }
}
