package bridge.view;

import static bridge.constant.ErrorConstant.ENTER_BRIDGE_LENGTH;
import static bridge.constant.ErrorConstant.PICK_COMMAND;
import static bridge.constant.ErrorConstant.PICK_POSITION;
import static bridge.util.InputValidator.validateDigit;
import static bridge.util.InputValidator.validateMoving;
import static bridge.util.InputValidator.validateRetryOrExit;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_LENGTH);
        return validateDigit(readLine());
    }

    public String readMoving() {
        System.out.println(PICK_POSITION);
        String moving = readLine();
        try {
            validateMoving(moving);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
        return moving;
    }

    public String readGameCommand() {
        System.out.println(PICK_COMMAND);
        String command = readLine();
        try {
            validateRetryOrExit(command);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
        return command;
    }
}
