package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Errors.NULL_ERROR;
import static bridge.Validator.bridgeSizeValidate;
import static bridge.Validator.numberValidate;
import static bridge.Validator.moveValidate;
import static bridge.Validator.reStartValidate;
import static bridge.view.IOMessage.INPUT_MOVE_MESSAGE;
import static bridge.view.IOMessage.INPUT_SIZE_MESSAGE;
import static bridge.view.IOMessage.INPUT_RESTART_MESSAGE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        System.out.println(INPUT_SIZE_MESSAGE.getMessage());
        String input = inputData();
        numberValidate(input);
        size = Integer.parseInt(input);
        bridgeSizeValidate(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE.getMessage());
        String input = inputData();
        moveValidate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESTART_MESSAGE.getMessage());
        String input = inputData();
        reStartValidate(input);
        return input;
    }

    private String inputData() {
        String input = Console.readLine();
        nullValidate(input);
        return input;
    }

    private void nullValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR.getMessage());
        }
    }
}
