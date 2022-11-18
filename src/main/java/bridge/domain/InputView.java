package bridge.domain;


import static bridge.common.message.ExceptionMessage.BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE;
import static bridge.common.message.ExceptionMessage.ERROR_CODE;

import bridge.common.message.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(ProcessHelper processHelper) {
        while (true) {
            try {
                String str = Console.readLine();
                if (processHelper.canItChangeBridgeSize(str)) {
                    throw new IllegalArgumentException(ERROR_CODE + BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE);
                }
                return Integer.parseInt(str);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
