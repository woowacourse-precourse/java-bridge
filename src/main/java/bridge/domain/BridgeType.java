package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeType {
    U(1),
    D(0),
    UNKNOWN(-1);

    private final int value;

    BridgeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BridgeType find(int value) {
        return Optional.ofNullable(values.get(value)).orElse(UNKNOWN);
    }

    private static final Map<Integer, BridgeType> values =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeType::getValue, Function.identity())));
}
