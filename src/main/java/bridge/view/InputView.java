package bridge.view;

import bridge.validator.BridgeLengthValidator;
import bridge.validator.RetryInputValidator;
import bridge.validator.SpaceToMoveValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        while (true) {
            try {
                String input = Console.readLine();
                BridgeLengthValidator.validateNaturalNumber(input);
                BridgeLengthValidator.validateRange(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public String readMoving() {
        while (true) {
            try {
                String input = Console.readLine();
                SpaceToMoveValidator.validateSpaceToMove(input);
                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public String readGameCommand() {
        while (true) {
            try {
                String input = Console.readLine();
                RetryInputValidator.validateRetryInput(input);
                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
