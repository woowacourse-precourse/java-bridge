package bridge;

import java.util.Arrays;

public enum UpDownChecker {
    correctUpLine1("U","U","U"," O "),
    correctUpLine2("U","U","D","   "),
    correctDownLine1("D","D","U","   "),
    correctDownLine2("D","D","D"," O "),
    UpButWrongLine1("D","U","U"," X "),
    UpButWrongLine2("D","U","D","   "),
    DownButWrongLine1("U","D","U","   "),
    DownButWrongLine2("U","D","D"," X "),
    ERROR("","","","");

    private final String bridge;
    private final String move;
    private final String nowLine;
    private final String checker;

    UpDownChecker(String bridge, String move, String nowLine, String checker) {
        this.bridge = bridge;
        this.move = move;
        this.nowLine = nowLine;
        this.checker = checker;
    }

    public static UpDownChecker fromConditions(String bridge, String move, String nowLine) {
        return Arrays.stream(UpDownChecker.values())
                .filter(UpDownChecker -> UpDownChecker.bridge.equals(bridge))
                .filter(UpDownChecker -> UpDownChecker.move.equals(move))
                .filter(UpDownChecker -> UpDownChecker.nowLine.equals(nowLine))
                .findAny()
                .orElse(ERROR);
    }

    public String getChecker() {
        return this.checker;
    }
}
