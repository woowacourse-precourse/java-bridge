package bridge.view;

import static bridge.validation.Validation.validateBridgeSize;
import static bridge.validation.Validation.validateGameCommand;
import static bridge.validation.Validation.validateMoveCommand;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readLine();
        validateBridgeSize(userInput);
        return Integer.parseInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다. U / D
     */
    public String readMoving() {
        String userInput = readLine();
        validateMoveCommand(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = readLine();
        validateGameCommand(userInput);
        return userInput;
    }
}
