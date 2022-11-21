package bridge.validation;

import static bridge.exception.ErrorEnum.INVALID_BRIDGE_GAME_MOVE_STATUS;
import static bridge.exception.ErrorEnum.INVALID_BRIDGE_INDEX;
import static bridge.exception.ErrorEnum.INVALID_BRIDGE_SIZE_STATE;
import static bridge.exception.ErrorEnum.INVALID_DIRECTION_INPUT;
import static bridge.game.BridgeGameStatus.RUNNING;

import bridge.game.BridgeGameStatus;
import java.util.List;

public class Validator {

    public static void validateListSizeEquals(int sizeA, int sizeB) {
        if (sizeA != sizeB) {
            throw new IllegalStateException(INVALID_BRIDGE_SIZE_STATE
                    .messageWithCause(sizeA + " != " + sizeB));
        }
    }

    public static void validateBridgeIndex(int size, int index) {
        if ((0 > index) || (index > size)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_INDEX.message());
        }
    }

    public static void validateBridgeElement(String upperElement, String lowerElement) {
        if (!List.of("O", "X").contains(upperElement) && !List.of("O", "X").contains(lowerElement)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_INDEX.message());
        }
    }

    public static void validateStatusAtMove(BridgeGameStatus status) {
        if (!status.equals(RUNNING)) {
            throw new IllegalStateException(INVALID_BRIDGE_GAME_MOVE_STATUS
                    .messageWithCause(status.text()));
        }
    }

    public static void validateDirectionInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_DIRECTION_INPUT
                    .messageWithCause(input));
        }
    }

}
