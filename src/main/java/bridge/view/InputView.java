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
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
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
