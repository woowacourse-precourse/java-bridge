package bridge.domain;

import java.util.Arrays;

public enum Result {
    FAIL("실패"), SUCCESS("성공"), ARRIVED("성공");

    final private String string;

    Result(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
