package bridge.model;

import java.util.Arrays;
import java.util.List;

public enum Position {


    UP("U", 1),
    DOWN("D", 0);

    public static final List<String> MOVING_OPTIONS = List.of("U", "D");
    private final String abbreviation;
    private final int generatedNumber;

    Position(String abbreviation, int generatedNumber) {
        this.abbreviation = abbreviation;
        this.generatedNumber = generatedNumber;
    }

    public static String getAbbreviationByNumber(int generatedNumber) {
        return findPosition(generatedNumber).abbreviation;
    }

    private static Position findPosition(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    public static void validateMovingInput(String input) {
        if (!MOVING_OPTIONS.contains(input)) {
            throw new IllegalArgumentException("U/D 중 이동할 칸을 입력해 주세요.");
        }
    }


}
