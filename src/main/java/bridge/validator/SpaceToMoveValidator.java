package bridge.validator;

import bridge.constants.ValidatorMessage;

public class SpaceToMoveValidator {

    private static final String UP = "U";
    private static final String DOWN = "D";

    public static void validateSpaceToMove(String nextSpace) {
        if (!nextSpace.equals(UP) && !nextSpace.equals(DOWN)) {
            throw new IllegalArgumentException(ValidatorMessage.NEXT_SPACE_IS_U_OR_D.toString());
        }
    }
}
