package bridge.io;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator = new Validator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputText.BRIDGE_SIZE.getInputText());
        String input = Console.readLine();
        validator.checkValidBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputText.MOVING.getInputText());
        String input = Console.readLine();
        validator.checkValidMoveInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputText.GAME_COMMAND.getInputText());
        String input = Console.readLine();
        validator.checkValidRetryInput(input);
        return input;
    }
}
