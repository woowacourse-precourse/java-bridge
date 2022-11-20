package bridge.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeMark {

    UP("U"), DOWN("D");

    public static final String ERROR_INVALID_MOVING_MARK = "[ERROR] 이동할 칸의 입력의 경우 U와 D 뿐이어야 합니다.";
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
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MOVING_MARK));
    }

    public static void validateInput(String mark) {
        Arrays.stream(BridgeMark.values())
                .map(BridgeMark::getMark)
                .filter(s -> s.equals(mark))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MOVING_MARK));
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

    public String getMark() {
        return mark;
    }
}
