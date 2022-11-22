package bridge;

import bridge.exception.WrongMovingException;
import java.util.Arrays;

public enum Row {

    DOWN("D"), UP("U");

    private String code;

    Row(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getRowCodeByIndex(int index) {
        return values()[index].getCode();
    }

    public static Row of(String code) {
        return Arrays.stream(values())
                .filter(v -> code.equals(v.code))
                .findFirst()
                .orElseThrow(WrongMovingException::new);
    }
}
