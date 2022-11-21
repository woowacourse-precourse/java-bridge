package bridge.domain;

import static bridge.util.Error.NOT_U_NOR_D;

/**
 * 정수 0과 1을 "D"와 "U"로 맵핑하는 역할을 한다.
 */
public enum Direction {

    DOWN("D"), UP("U");

    private final String compact;

    Direction(String compact) {
        this.compact = compact;
    }

    /**
     * 성공적으로 움직였는지 체크한다. 실패했다면 사용자에게 재시도 여부를 입력받는다.
     * @param number 정수 0 또는 1만 받는다.
     * @return number가 0이면 "D", 1이면 "U"
     */
    public static String valueOf(int number) {
        if (number == 0) {
            return Direction.DOWN.compact;
        } else if (number == 1) {
            return Direction.UP.compact;
        }
        throw new IllegalArgumentException(NOT_U_NOR_D.toString());
    }
}
