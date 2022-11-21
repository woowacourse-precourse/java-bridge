package bridge.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BridgeMark {

    UP("U", 1), DOWN("D", 0);

    private static final String ERROR_INVALID_MOVING_MARK = "[ERROR] 이동할 칸의 입력의 경우 U와 D 뿐이어야 합니다.";
    private static final String ERROR_INVALID_BRIDGE_NUMBER = "[ERROR] 다리의 숫자 값은 1 or 0만 가능합니다.";

    private final String mark;
    private final int number;

    BridgeMark(String mark, int number) {
        this.mark = mark;
        this.number = number;
    }

    public static void validateInput(String mark) {
        BridgeMark.of(mark);
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

    private boolean isEqualMark(String mark) {
        return this.mark.equals(mark);
    }

    public static String mapToString(int number) {
        return Arrays.stream(BridgeMark.values())
                .filter(bridgeMark -> bridgeMark.isEqualNumber(number))
                .map(BridgeMark::getMark)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER));
    }

    private boolean isEqualNumber(int number) {
        return this.number == number;
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
