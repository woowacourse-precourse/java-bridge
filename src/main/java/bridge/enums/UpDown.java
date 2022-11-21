package bridge.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UpDown {
    UP("U",1),
    DOWN("D",0)
    ;

    private final String label;
    private final int number;

    UpDown(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public String label() {
        return label;
    }

    public int number() {
        return number;
    }

    private static final Map<String, UpDown> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(UpDown::label, Function.identity()));

    private static final Map<Integer, UpDown> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(UpDown::number, Function.identity()));

    public static UpDown valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static UpDown valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }
}
