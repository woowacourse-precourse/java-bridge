package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeSpace {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String type;
    private final String title;
    private final int value;

    private static final Map<Integer, BridgeSpace> values =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeSpace::getValue, Function.identity())));

    private static final Map<String, BridgeSpace> types =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BridgeSpace::getType, Function.identity())));

    BridgeSpace(String type, String title, int value) {
        this.type = type;
        this.title = title;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public static BridgeSpace findByValue(int value) {
        return values.get(value);
    }

    public static BridgeSpace findByType(String type) {
        return types.get(type);
    }

}
