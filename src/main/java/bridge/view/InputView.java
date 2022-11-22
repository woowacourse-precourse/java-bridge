package bridge.view;

import bridge.view.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.Constants.*;

public class InputView {

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
