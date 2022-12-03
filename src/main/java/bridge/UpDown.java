package bridge;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UpDown {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String letter;

    UpDown(int number, String letter) {
        this.number = number;
        this.letter = letter;
    }

    private int number() {
        return this.number;
    }

    private String letter() {
        return this.letter;
    }

    private static final Map<Integer, UpDown> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(UpDown::number, Function.identity()));

    public static String numberToLetter(int number) {
        return BY_NUMBER.get(number).letter();
    }
}
