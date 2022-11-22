package bridge;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Movement {
    UP(1, "U"),
    DOWN(0, "D");

    private int input;
    private String value;

    private Movement(int input, String value) {
        this.input = input;
        this.value = value;
    }

    public int input() {
        return input;
    }

    public String value() {
        return value;
    }

    private static final Map<Integer, Movement> BY_INPUT =
            Stream.of(values()).collect(Collectors.toMap(Movement::input, Function.identity()));

    private static final Map<String, Movement> BY_VALUE =
            Stream.of(values()).collect(Collectors.toMap(Movement::value, Function.identity()));

    public static int getInput(String value) {
        return BY_VALUE.get(value).input;
    }

    public static String getValue(int input) {
        return BY_INPUT.get(input).value;
    }

}