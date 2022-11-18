package bridge.domain;

import bridge.util.ErrorMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Movement {
    U(1),
    D(0);

    private int code;
    private static final Map<Integer, Movement> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(Movement::getCode, e -> e));

    Movement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Movement findByMovement(int code) {
        return BY_CODE.get(code);
    }

    public static Movement toMovement(String label) {
        Movement movement = findByMovement(label);
        if(Objects.isNull(movement)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MOVEMENT);
        }
        return movement;
    }

    private static Movement findByMovement(String label) {
        return Arrays.stream(values())
                .filter(value -> value.name().equals(label))
                .findAny()
                .orElse(null);
    }

}
