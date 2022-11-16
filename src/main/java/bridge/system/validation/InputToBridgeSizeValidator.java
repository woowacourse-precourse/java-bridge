package bridge.system.validation;

public class InputToBridgeSizeValidator {

    public static final String NOT_ONLY_NATURAL_NUMBER_MESSAGE = "자연수만 입력 가능합니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "다리의 길이는 %d 이상 %d 이하의 길이로만 입력할 수 있습니다.";
    public static final String ONLY_NATURAL_NUMBER_REGEX = "^[0-9]+$";

    public static void validate(String target) {
        isTargetOnlyNaturalNumber(target);
        int targetNumber = convertToNumber(target);
        isTargetInValidRange(targetNumber, 3, 20);
    }

    private static void isTargetOnlyNaturalNumber(String target) {
        if (!target.matches(ONLY_NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_NATURAL_NUMBER_MESSAGE);
        }
    }

    private static int convertToNumber(String target) {
        return Integer.parseInt(target);
    }

    private static void isTargetInValidRange(int targetNumber, int minRange, int maxRange) {
        if (targetNumber < minRange || maxRange < targetNumber) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_RANGE_MESSAGE_FORMAT, minRange, maxRange)
            );
        }
    }
}
