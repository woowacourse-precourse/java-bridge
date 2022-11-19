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
        try {
            String userInput = readLine();
            validateBridgeSize(userInput);
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("다시 입력해주세요.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다. U / D
     */
    public String readMoving() {
        try {
            String userInput = readLine();
            validateMoveCommand(userInput);
            return userInput;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("다시 입력해주세요.");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String userInput = readLine();
            validateGameCommand(userInput);
            return userInput;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("다시 입력해주세요.");
            return readGameCommand();
        }
    }
}
