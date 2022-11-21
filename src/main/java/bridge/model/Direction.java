package bridge.model;

import bridge.config.ErrorMessageConstant;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 각 칸에서의 위 / 아래 두 방향을 나타낸다.
 */
public enum Direction {
    DOWN("D"),
    UP("U");

    private static final Map<String, String> DIR_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Direction::getCode, Direction::name))
    );
    private final String code;

    Direction(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    /**
     * 코드 값으로 방향 상수 불러오는 함수
     * <p>
     * @param code "D" -> DOWN, "U" -> UP 반환
     * @return DOWN / UP
     * @throws IllegalArgumentException "D", "U" 외 문자 입력 시 예외 발생
     */
    public static Direction of(final String code) throws IllegalArgumentException {
        String name = DIR_MAP.get(code);
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.DIRECTION_NOT_FOUND);
        }
        return Direction.valueOf(name);
    }
}
