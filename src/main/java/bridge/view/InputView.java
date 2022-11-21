package bridge.view;

import bridge.enums.Inputs;
import bridge.enums.OutMsg;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputValidator inputValidator = new InputValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(OutMsg.INIT.getMessage() + "\n");
        System.out.println(OutMsg.BRIDGE_SIZE_REQUEST.getMessage());
        String bridgeSize = Console.readLine();
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Inputs readMoving() {
        System.out.println(OutMsg.MOVE_REQUEST.getMessage());
        String move = Console.readLine();
        inputValidator.validateMovement(move);
        if (move.equals(Inputs.MOVE_UP.getMessage())) {
            return Inputs.MOVE_UP;
        }
        return Inputs.MOVE_DOWN;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(OutMsg.RETRY_REQUEST.getMessage());
        String retry = Console.readLine();
        inputValidator.validateRetry(retry);
        return retry;
    }
}
