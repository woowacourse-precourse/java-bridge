package bridge.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Key {
    DOWN(0, "D"),
    UP(1, "U");

    private int number;
    private String command;

    Key(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public int number() {
        return number;
    }
    public String command(){
        return command;
    }

    private static final Map<Integer, Key> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(Key::number, Function.identity()));

    public static Key valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }

}
