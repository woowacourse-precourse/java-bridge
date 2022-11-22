package bridge.domain.validation;

import static bridge.config.ExceptionMessage.WRONG_BRIDGE_SQUARE;

import bridge.command.enums.PlayerMove;
import java.util.List;

public class BridgeValidation {

    public static void validate(List<String> squares) {
        validateSquares(squares);
    }

    private static void validateSquares(List<String> squares) {
        if (hasUnknownSquare(squares)) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SQUARE.toString());
        }
    }

    private static boolean hasUnknownSquare(List<String> squares) {
        return !squares.stream().allMatch(PlayerMove::isInPlayerMove);
    }
}
