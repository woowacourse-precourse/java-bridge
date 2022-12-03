package bridge.model;

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
        return Position.fromNumber(generatedNumber).abbreviation;
    }

    private static Position fromNumber(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ERROR_GENERATED_NUMBER));
    }

    public static Position fromAbbreviation(String abbreviation) {
        return Arrays.stream(Position.values())
                .filter(position -> position.abbreviation.equals(abbreviation))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ERROR_MOVING_INPUT));
    }

    public boolean isSame(String string) {
        return string.equals(this.abbreviation);
    }

    public boolean isRightPlace(Position diagramPosition) {
        if (this == diagramPosition) {
            return true;
        }
        return false;
    }

}
