package bridge;

import bridge.exception.WrongMovingException;
import java.util.Arrays;

public enum Moving {

    DOWN("D"), UP("U");

    private String code;

    Moving(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getMovingCodeByIndex(int index) {
        return values()[index].getCode();
    }

    public static Moving of(String code) {
        return Arrays.stream(values())
                .filter(v -> code.equals(v.code))
                .findFirst()
                .orElseThrow(WrongMovingException::new);
    }
}
