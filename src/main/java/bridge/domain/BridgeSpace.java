package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeSpace {
    UP("U", 1),
    DOWN("D",0);

    private final String type;
    private final int value;

    BridgeSpace(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BridgeSpace find(int value) {
        return values.get(value);
    }

    private static final Map<Integer, BridgeSpace> values =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeSpace::getValue, Function.identity())));
}
