package bridge.view;

import bridge.view.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.Constants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int inputToInt = getUserInputToInt();
            Validator.validateForRangeException(inputToInt);
            return inputToInt;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            OutputView.printGameMessage(SELECT_UP_OR_DOWN_MESSAGE);
            String input = getUserInputToString();
            Validator.validateForIllegalInputUpOrDown(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            OutputView.printGameMessage(SELECT_RESTART_OR_QUIT_MESSAGE);
            String input = getUserInputToString();
            Validator.validateForIllegalInputRestartOrQuit(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readGameCommand();
        }
    }

    private String getUserInputToString() {
        return Console.readLine();
    }

    private int getUserInputToInt() {
        try {
            OutputView.printGameMessage(REQUEST_FOR_BRIDGE_SIZE_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            return getUserInputToInt();
        }
    }

}
