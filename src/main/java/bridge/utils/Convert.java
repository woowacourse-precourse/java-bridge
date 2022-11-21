package bridge.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String UP = "U";
    public static final String DOWN = "D";

    public static List<String> toUpAndDownBridge(List<Integer> bridge) {
        return bridge.stream()
                .map(String::valueOf)
                .map(value -> value.replace(ONE, UP))
                .map(value -> value.replace(ZERO, DOWN))
                .collect(Collectors.toList());
    }
}
