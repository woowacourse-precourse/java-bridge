package bridge.model;

import bridge.config.ErrorMessageConstant;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Direction {
    DOWN(0, "D"),
    UP(1, "U");

    private static final Map<Integer, String> DIR_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Direction::getCode, Direction::name))
    );

    private final int code;
    private final String token;

    Direction(int code, String token) {
        this.code = code;
        this.token = token;
    }

    public int getCode() {
        return this.code;
    }

    public String getToken() {
        return this.token;
    }

    /**
     * 코드 값으로 방향 상수 불러오는 함수
     * 0 -> DOWN, 1 -> UP 반환
     * @param code 0 또는 1의 상수 값
     * @return DOWN / UP
     * @throws IllegalArgumentException 0, 1을 제외한 숫자 입력 시 예외 발생
     */
    public static Direction of(final int code) throws IllegalArgumentException {
        String name = DIR_MAP.get(code);
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.CAN_NOT_FIND_DIRECTION);
        }
        return Direction.valueOf(name);
    }
}
