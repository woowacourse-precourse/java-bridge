package bridge.io;

import bridge.enums.InGameMessage;
import bridge.io.validation.*;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private InputValidation inputValidation;

    public InputView() {
        inputValidation = new InputValidation();
    }

    /**
     * 메서드의 인자, 이름, 반환타입 변경 가능
     * 사용자 값 입력을 위해 필요한 메서드 추가 가능
     */

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InGameMessage.INPUT_BRIDGE_LENGTH.getMessage());
        String input = Console.readLine();
        return inputValidation.validateAndReturnBridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InGameMessage.INPUT_DIRECTION.getMessage());
        String input = Console.readLine();
        return inputValidation.validateAndReturnMove(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InGameMessage.INPUT_RETRY_OR_QUIT.getMessage());
        String input = Console.readLine();
        return inputValidation.validateAndReturnCommand(input);
    }

}