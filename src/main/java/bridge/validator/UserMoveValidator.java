package bridge.validator;

import static bridge.validator.ErrorMessage.*;

import java.util.Objects;

public class UserMoveValidator {

    public static String runUserMoveValidator(String userMove) {
        if (isNotUorD(userMove)) {
            throw new IllegalArgumentException(NOT_U_OR_D.getErrorMessage());
        }
        return userMove;
    }

    private static boolean isNotUorD(String userMove) {
        return !(Objects.equals(userMove, "U") || Objects.equals(userMove, "D"));
    }
}
