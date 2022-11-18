package bridge.domain;


import static bridge.common.message.ExceptionMessage.BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE;
import static bridge.common.message.ExceptionMessage.ERROR_CODE;
import static bridge.common.message.ExceptionMessage.READ_MOVING_INCORRECT_MESSAGE;

import bridge.common.message.ExceptionMessage;
import bridge.domain.exception.BridgeSizeException;
import bridge.domain.exception.ReadMovingException;
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
                String bridgeSize = Console.readLine();
                bridgeSizeValidation(processHelper, bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(ProcessHelper processHelper) {
        while (true) {
            try {
                String moving = Console.readLine();
                movingValidation(processHelper, moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void movingValidation(ProcessHelper processHelper, String moving) {
        if (processHelper.checkCharIsUOrD(moving)) {
            throw new ReadMovingException(ERROR_CODE + READ_MOVING_INCORRECT_MESSAGE);
        }
    }

    private void bridgeSizeValidation(ProcessHelper processHelper, String str) {
        if (processHelper.canItChangeBridgeSize(str)) {
            throw new BridgeSizeException(ERROR_CODE + BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE);
        }
    }
}
