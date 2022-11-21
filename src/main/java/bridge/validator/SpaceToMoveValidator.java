package bridge.validator;

import bridge.constant.ValidatorMessage;

public class SpaceToMoveValidator {

    public static void validateSpaceToMove(String nextSpace) {
        if (!nextSpace.equals("U") && !nextSpace.equals("D")) {
            throw new IllegalArgumentException(ValidatorMessage.NEXT_SPACE_IS_U_OR_D.toString());
        }
    }
}
