package bridge.util;

import bridge.domain.Dir;
import java.util.List;
import java.util.StringJoiner;

public class Formatter {

    public static String formatter(List<Dir> dirs) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        for (Dir dir : dirs) {
            sj.add(dir.getIsMovable());
        }
        return sj.toString();
    }
}
