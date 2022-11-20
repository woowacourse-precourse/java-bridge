package bridge.model;

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

    public static String findAbbreviationByNumber(int generatedNumber) {
        return Position.from(generatedNumber).abbreviation;
    }

    private static Position from(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("0, 1 중의 숫자로만 다리를 생성할 수 있습니다."));
    }

    public static Position from(String abbreviation) {
        return Arrays.stream(Position.values())
                .filter(position -> position.abbreviation.equals(abbreviation))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("U/D 중 이동할 칸을 입력해 주세요."));
    }

    public static boolean isSame(String string, Position position) {
        return string.equals(position.abbreviation);
    }

    public static String returnByPosition(Position diagramPosition, Position position, String string) {
        if (position == diagramPosition) {
            return string;
        }
        return " ";
    }
}
