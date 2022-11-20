package bridge.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeMark {

    UP("U"), DOWN("D");

    private final String mark;

    BridgeMark(String mark) {
        this.mark = mark;
    }

    public static List<BridgeMark> of(List<String> marks) {
        return marks.stream()
                .map(BridgeMark::of)
                .collect(Collectors.toList());
    }

    public static BridgeMark of(String mark) {
        return Arrays.stream(BridgeMark.values())
                .filter(bridgeMark -> bridgeMark.isEqualMark(mark))
                .findFirst()
                .orElseThrow();
    }

    private boolean isEqualMark(String mark) {
        return this.mark.equals(mark);
    }

    public boolean isUp() {
        return this == UP;
    }

    public boolean isDown() {
        return this == DOWN;
    }
}
