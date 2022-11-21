package bridge.util;

import bridge.domain.result.PassingDirectionType;
import java.util.List;
import java.util.StringJoiner;

public class Formatter {

    public static String formatter(List<PassingDirectionType> types) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        for (PassingDirectionType type : types) {
            sj.add(type.getIsMovable());
        }
        return sj.toString();
    }
}
