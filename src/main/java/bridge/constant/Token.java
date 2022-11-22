package bridge.constant;

import java.util.List;

public enum Token {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String mark;

    Token(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public static List<String> getMovingMark() {
        return List.of(UP.getMark(), DOWN.getMark());
    }

    public static List<String> getRetryMark() {
        return List.of(RESTART.getMark(), QUIT.getMark());
    }
}
