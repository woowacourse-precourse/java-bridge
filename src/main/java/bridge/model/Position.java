package bridge.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Position {


    UP("U", 1),
    DOWN("D", 0);

    private final String abbreviation;
    private final int generatedNumber;

    Position(String abbreviation, int generatedNumber) {
        this.abbreviation = abbreviation;
        this.generatedNumber = generatedNumber;
    }

    public static String findAbbreviationByNumber(int generatedNumber) {
        return findPositionByNumber(generatedNumber).abbreviation;
    }

    private static Position findPositionByNumber(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    public static Position findPositionByAbbreviation(String abbreviation) {
        return Arrays.stream(Position.values())
                .filter(position -> position.abbreviation.equals(abbreviation))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    public static boolean isSame(String string, Position position) {
        return string.equals(position.abbreviation);
    }

    public static void validateMovingInput(String input) {
        if (!getMovingInputOptions().contains(input)) {
            throw new IllegalArgumentException("U/D 중 이동할 칸을 입력해 주세요.");
        }
    }

    private static List<String> getMovingInputOptions() {
        return Arrays.stream(Position.values())
                .map(position -> position.abbreviation)
                .collect(Collectors.toList());
    }


}
