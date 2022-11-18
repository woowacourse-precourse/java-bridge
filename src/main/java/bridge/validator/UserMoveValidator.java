package bridge.validator;

import static bridge.validator.ErrorMessage.*;

public class UserMoveValidator {

    public static String runUserMoveValidator(String userMove) {
        if (isNotUorD(userMove)) {
            throw new IllegalArgumentException(NOT_U_OR_D.getErrorMessage());
        }
        return userMove;
    }

    private static boolean isNotUorD(String userMove) {
        return !(userMove == "U" || userMove == "D");
    }
}
