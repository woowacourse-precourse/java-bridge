package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandType {
    R,
    Q,
    ;

    public static List<String> getNames() {
        return Arrays.stream(values())
            .map(Enum::name)
            .collect(Collectors.toList());
    }
}
