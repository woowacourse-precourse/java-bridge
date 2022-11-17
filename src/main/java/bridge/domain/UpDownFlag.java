package bridge.domain;

import static bridge.ExceptionConst.*;

public enum UpDownFlag {
    UP("U", 1),
    DOWN("D", 0);

    private final String flag;
    private final int code;

    UpDownFlag(String flag, int code) {
        this.flag = flag;
        this.code = code;
    }

    public static UpDownFlag ofString(String flag) {
        if (flag.equals(UP.flag)) {
            return UP;
        }
        if (flag.equals(DOWN.flag)) {
            return DOWN;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_U_OR_D);
    }

    public static String codeToFlag(int code) {
        if (code == UP.code) {
            return UP.flag;
        }
        if (code == DOWN.code) {
            return DOWN.flag;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_0_OR_1);
    }
}
