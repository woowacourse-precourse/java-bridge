package bridge.view.validation;

import bridge.vo.ErrorMessage;
import bridge.vo.StepDirectionCommand;

public class InputMoveValidator {

    public static void validate(String input) {
        if (isNotUAndIsNotB(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_U_AND_NOT_D_MESSAGE.toString());
        }
    }

    public static boolean isNotUAndIsNotB(String input) {
        return !(input.equals(StepDirectionCommand.U.toString())
                || input.equals(StepDirectionCommand.D.toString()));
    }
}
