package bridge.validator;

public class MovingValidator {
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static boolean isRightCharacter(String input) {
        if (input.equals(UP) || input.equals(DOWN)) {
            return true;
        }
        return false;
    }

    public static void validateMoving(String input) {
        if (!isRightCharacter(input)) {
            throw new IllegalArgumentException("플레이어가 이동할 칸은 U와 D 중 하나의 문자여야 합니다.");
        }
    }
}
