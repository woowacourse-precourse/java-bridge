package bridge.domain.validation;

import bridge.command.enums.PlayerMove;
import bridge.config.ExceptionMessage;
import java.util.List;

public class BridgeValidation {

    public static void validate(List<String> squares) {
        validateSquaresElement(squares);
    }

    private static void validateSquaresElement(List<String> squares) {
        if (hasUnknownElement(squares)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_ELEMENT.toString());
        }
    }

    private static boolean hasUnknownElement(List<String> squares) {
        return !squares.stream().allMatch(PlayerMove::isInPlayerMove);
    }
}
