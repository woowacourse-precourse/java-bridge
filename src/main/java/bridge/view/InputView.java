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
        System.out.println(OutMsg.BRIDGE_SIZE_REQUEST.getMessage());
        try {
            String bridgeSize = inputValidator.validateBridgeSize(Console.readLine());
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Inputs readMoving() {
        System.out.println(OutMsg.MOVE_REQUEST.getMessage());
        try {
            String move = inputValidator.validateMovement(Console.readLine());
            return moveToInputElement(move);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private Inputs moveToInputElement(String move) {
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
        try {
            return inputValidator.validateRetry(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
