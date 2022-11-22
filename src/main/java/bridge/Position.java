package bridge;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Position {
    UP(1, "U"), DOWN(0, "D");

    private static final Map<Integer, Position> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(Position::getNumber, Function.identity()));
    private final int number;
    private final String value;

    Position(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public static Position valueOfCode(int code) {
        return BY_NUMBER.get(code);
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }
}
