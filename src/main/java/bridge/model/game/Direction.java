package bridge.model.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Direction {
    D(0, "아래"), U(1, "위");

    private final String info;
    private final int value;

    Direction(int value, String info) {
        this.value = value;
        this.info = info;
    }

    public static String getName(int value) {
        for (Direction direction : values()) {
            if (direction.value == value)
                return direction.name();
        }
        return null;
    }

    public static List<String> names() {
        return Arrays.stream(values()).map(Enum::name).collect(Collectors.toList());
    }

    public static String info() {
        StringBuilder msg = new StringBuilder("(");
        List<String> infos = new ArrayList<>();
        for (Direction direction : values()) {
            infos.add(direction.info + ": " + direction.name());
        }
        msg.append(String.join(", ", infos));
        msg.append(")");
        return msg.toString();
    }
}
