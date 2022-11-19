package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeType {

    U(1),
    D(0),
    ;

    private final Integer value;

    BridgeType(Integer value) {
        this.value = value;
    }

    public static BridgeType valueOf(Integer value) {
        return Arrays.stream(BridgeType.values())
            .filter(type -> type.getValue().equals(value))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("정의되지 않은 발판 타입입니다."));
    }

    public static List<String> getNames() {
        return Arrays.stream(values())
            .map(Enum::name)
            .collect(Collectors.toList());
    }

    public Integer getValue() {
        return value;
    }
}
