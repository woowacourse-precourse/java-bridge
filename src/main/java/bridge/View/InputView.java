package bridge.View;

import bridge.Domain.InputConverter;
import bridge.Domain.InputValidator;
import bridge.Constant.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public void printStartMessage() {
        System.out.println(InputMessage.START_GAME);
    }

    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_BRIDGE_SIZE);

        String input = readLine();

        try {
            int bridgeSize = InputConverter.convertToInt(input);

            return bridgeSize;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }


    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_SELECTION);
        String input = readLine();

        try {
            InputValidator.validateSelectionInput(input);

            return input;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_COMMAND);

        String input = readLine();
        try {
            InputValidator.validateCommandInput(input);

            return input;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }
}
