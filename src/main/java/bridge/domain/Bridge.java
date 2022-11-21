package bridge.domain;

import bridge.config.Direction;
import bridge.config.ErrorMessageConstant;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리에 속한 칸들을 관리하고 특정 칸으로 이동 가능 여부를 파악하는 클래스
 */
public class Bridge {

    private final List<Direction> allowMove;

    /**
     * 다리를 생성 및 초기화한다.
     * @param dirs 위 : "U", 아래 : "D"로 표현된 방향 정보
     * @throws IllegalArgumentException "U", "D" 외의 다른 문자가 포함되거나, 3 이상 20 이하의 길이가 아닌 경우
     */
    public Bridge(List<String> dirs) throws IllegalArgumentException {
        bridgeSizeValidation(dirs.size());
        allowMove = dirs.stream()
                .map(Direction::of)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * 다리의 한 칸에서 특정 방향으로 이동이 가능한지 반환
     * <p>
     * 다리가 가진 칸을 벗어나는 입력은 false 로 반환
     * @param position 칸의 위치
     * @param direction 이동할 방향
     * @return 이동 가능 여부
     */
    public boolean isAllow(int position, Direction direction) {
        try {
            return allowMove.get(position) == direction;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getNumOfCells() {
        return this.allowMove.size();
    }


    /**
     * 다리의 길이를 검증
     * @param size 다리의 길이
     * @throws IllegalArgumentException 다리의 길이가 3 이상 20 이하를 만족하지 않는 경우 예외처리
     */
    private void bridgeSizeValidation(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_BRIDGE_SIZE);
        }
    }

    /**
     * 테스트 및 로그를 위한 문자열 반환
     * @return 다리 정보를 "U"와 "D"로 구성된 하나의 문자열로 반환
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        allowMove.forEach(d -> sb.append(d.getCode()));
        return sb.toString();
    }
}
