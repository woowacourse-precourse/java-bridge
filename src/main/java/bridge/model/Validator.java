package bridge.model;

public class Validator {

    public static void validateRangeOfInt(int num, int start, int end) {
        if (start > num || num > end) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_INT_RANGE.getMsg());
        }
    }

    public static void validateDir(String dir) {
        try {
            Direction.valueOf(dir);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_DIR.getMsg());
        }
    }

    public static void validateCommend(String commend) {
        try {
            Command.valueOf(commend);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_COMMEND.getMsg());
        }
    }

    public static void validateNumeric(String input) {
        boolean isNotDigit = !input.chars().mapToObj(i -> (char) i)
            .allMatch(Character::isDigit);

        if (isNotDigit) {
            throw new IllegalArgumentException(ErrorMsg.NOT_A_NUMBER.getMsg());
        }
    }
}
