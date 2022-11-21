package bridge.util;

import bridge.domain.DirectionType;
import java.util.List;
import java.util.StringJoiner;

public class Formatter {

    public static String formatter(List<DirectionType> dirs) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        for (DirectionType dir : dirs) {
            sj.add(dir.getIsMovable());
        }
        return sj.toString();
    }
}
