package bridge.validator;

public class DirectionSelectionValidator {
    private static final String UP_DIRECTION = "U";
    private static final String DOWN_DIRECTION = "D";

    public static void validate(String direction) {
        if (!isEqualUpMessage(direction) && !isEqualDownMessage(direction)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEqualUpMessage(String direction) {
        return direction.equals(UP_DIRECTION);
    }

    private static boolean isEqualDownMessage(String direction) {
        return direction.equals(DOWN_DIRECTION);
    }
}
