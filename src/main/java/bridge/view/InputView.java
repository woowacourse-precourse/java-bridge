package bridge.view;

import bridge.constants.InputMessage;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.RetryValidator;
import bridge.validator.UserMoveValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {



    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        System.out.println(InputMessage.READ_BRIDGE_SIZE);
        String strSize = Console.readLine();
        return BridgeSizeValidator.runBridgeSizeValidator(strSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.READ_USER_MOVING);
        String userMove = Console.readLine();
        return UserMoveValidator.runUserMoveValidator(userMove);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.READ_RETRY_FLAG);
        String retryFlag = Console.readLine();
        return RetryValidator.runRetryValidator(retryFlag);
    }
}
