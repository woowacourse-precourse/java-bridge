package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static String ERROR_MSG = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String userInput = readUserInput();
            InputViewValidator.validateNumberFormat(userInput);
            int bridgeSize = Integer.parseInt(userInput);
            InputViewValidator.validateBridgeLength(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MSG + e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String step = readUserInput();
            InputViewValidator.validateBridgeStep(step);
            return step;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MSG + e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String cmd = readUserInput();
            InputViewValidator.validateRestartCommand(cmd);
            return (cmd);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MSG + e.getMessage());
            return readGameCommand();
        }
    }

    private String readUserInput() {
        return Console.readLine();
    }

}
