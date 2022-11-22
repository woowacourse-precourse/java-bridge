package bridge.Enum;

import java.util.HashMap;
import java.util.Map;

public enum Result {
    SURVIVE("O","성공"),
    FAIL("X","실패"),
    SPACE(" "," "),
    ;

    private static final Map<String, String> signToPrint = new HashMap<>();
    static {
        for (Result result : values()) {
            signToPrint.put(result.sign, result.print);
        }
    }

    private final String sign;
    private final String print;

    Result(String sign, String print) {
        this.sign = sign;
        this.print = print;
    }

    public String getSign() {
        return this.sign;
    }

    public static String changeSignToPrint(String sign) {
        return signToPrint.get(sign);
    }
}
