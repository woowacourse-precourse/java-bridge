package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeSpaceType {
    U(1),
    D(0),
    UNKNOWN(-1);

    private final int value;

    BridgeSpaceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BridgeSpaceType find(int value) {
        return Optional.ofNullable(values.get(value)).orElse(UNKNOWN);
    }

    private static final Map<Integer, BridgeSpaceType> values =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeSpaceType::getValue, Function.identity())));
}
