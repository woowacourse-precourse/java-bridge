package bridge.view;

import bridge.type.BridgeGameCommandType;
import bridge.type.BridgeSideType;
import bridge.ExceptionMesssage;
import bridge.validate.ValidateInput;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private OutputView outputView = new OutputView();
    private ValidateInput validateInput = new ValidateInput();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            validateInput.validateInputBridgeSize(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.BRIDGE_SIZE_ERROR);
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        try {
            validateInput.validateInputBridgeSide(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.BRIDGE_MOVING_ERROR);
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        try {
            validateInput.validateInputGameCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.GAME_COMMAND_ERROR);
            return readGameCommand();
        }
        return input;
    }
}
