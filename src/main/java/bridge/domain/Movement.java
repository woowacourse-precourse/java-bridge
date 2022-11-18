package bridge.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Movement {
    U(1),
    D(0);

    private int route;
    private static final Map<Integer, Movement> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(Movement::getCode, e -> e));

    Movement(int code) {
        this.route = code;
    }

    public int getCode() {
        return route;
    }

    public static Movement findByMovement(int code) {
        return BY_CODE.get(code);
    }

}
