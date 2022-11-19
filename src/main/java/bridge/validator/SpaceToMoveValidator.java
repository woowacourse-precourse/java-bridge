package bridge.validator;

public class SpaceToMoveValidator {

    public static final String NEXT_SPACE_IS_U_OR_D = "[ERROR] 이동할 칸은 위 : U, 아래 : D로 입력해주세요.";

    public static void validateSpaceToMove(String nextSpace) {
        if (nextSpace != "U" || nextSpace != "D") {
            throw new IllegalArgumentException(NEXT_SPACE_IS_U_OR_D);
        }
    }
}
