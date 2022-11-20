package bridge.constant;

import java.util.Arrays;

public enum Bridge {
    MOVE_UP("U", "위", 1),
    MOVE_DOWN("D", "아래", 0);

    private final String move;
    private final String detail;
    private final int number;

    Bridge(String move, String detail, int number) {
        this.move = move;
        this.detail = detail;
        this.number = number;
    }

    public String getMove() {
        return move;
    }

    public String getDetail() {
        return detail;
    }

    public static Bridge inspectMove(String move) {
        Arrays.stream(Bridge.values())
                .filter(bridge -> bridge)
    }
}
