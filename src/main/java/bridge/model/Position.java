package bridge.model;

import static bridge.util.Constants.BRIDGE_WHITE_SPACE;
import static bridge.util.ErrorMessage.ERROR_GENERATED_NUMBER;
import static bridge.util.ErrorMessage.ERROR_MOVING_INPUT;

import java.util.Arrays;

public enum Position {


    UP("U", 1),
    DOWN("D", 0);


    private final String abbreviation;
    private final int generatedNumber;

    Position(String abbreviation, int generatedNumber) {
        this.abbreviation = abbreviation;
        this.generatedNumber = generatedNumber;
    }

    public static String getAbbreviation(int generatedNumber) {
        return Position.from(generatedNumber).abbreviation;
    }

    private static Position from(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ERROR_GENERATED_NUMBER));
    }

    public static Position from(String abbreviation) {
        return Arrays.stream(Position.values())
                .filter(position -> position.abbreviation.equals(abbreviation))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ERROR_MOVING_INPUT));
    }

    public static boolean isSame(String string, Position position) {
        return string.equals(position.abbreviation);
    }

    public static boolean isNone(Position diagramPosition, Position position) {
        if (diagramPosition == position) {
            return false;
        }
        return true;
    }

}
