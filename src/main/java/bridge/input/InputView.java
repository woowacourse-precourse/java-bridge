package bridge.input;

import bridge.type.ValidationType;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validate(ValidationType.CHECK_SIZE, input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + " 다시 입력해주세요.");
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String input = Console.readLine();
            validate(ValidationType.CHECK_MOVING, input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + " 다시 입력해주세요.");
        }
        return "";
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String input = Console.readLine();
            validate(ValidationType.CHECK_GAME_COMMAND, input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + " 다시 입력해주세요.");
        }
        return "";
    }

    public void validate(ValidationType validationType, String input) {
        if (!ValidationType.validate(validationType, input)) {
            String errorMessage = validationType.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
