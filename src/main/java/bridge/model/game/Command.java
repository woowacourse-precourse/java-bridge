package bridge.model.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Command {
    R("재시도"), Q("종료");

    private final String info;

    Command(String info) {
        this.info = info;
    }

    public static List<String> names() {
        return Arrays.stream(values()).map(Enum::name).collect(Collectors.toList());
    }

    public static String info() {
        StringBuilder msg = new StringBuilder("(");
        List<String> infos = new ArrayList<>();
        for (Command direction : values()) {
            infos.add(direction.info + ": " + direction.name());
        }
        msg.append(String.join(", ", infos));
        msg.append(")");
        return msg.toString();
    }
}
