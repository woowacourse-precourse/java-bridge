package bridge.view;

import bridge.type.ErrorType;
import bridge.valid.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String SELECT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RESUME_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        int size = 0;
        try {
            size = convertToInt(Console.readLine());
            return size;
        } catch (IllegalArgumentException e) {
            printError(ErrorType.INPUT_BRIDGE_SIZE_ERROR_TYPE.getText());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(SELECT_MOVING);
        String command = Console.readLine();
        try {
            Validation.inputMoveSquareValid(command);
            return command;
        } catch (IllegalArgumentException e) {
            printError(ErrorType.INPUT_SQUARE_ERROR_TYPE.getText());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESUME_GAME);
        String command = Console.readLine();
        try {
            Validation.inputResumeCommandValid(command);
            return command;
        } catch (IllegalArgumentException e) {
            printError(ErrorType.INPUT_RESUME_COMMAND_ERROR_TYPE.getText());
            return readGameCommand();
        }
    }

    public void printError(String text) {
        System.out.println(text);
    }

    public int convertToInt(String input) {
        Validation.inputNumberValid(input);
        return Integer.parseInt(input);
    }
}
