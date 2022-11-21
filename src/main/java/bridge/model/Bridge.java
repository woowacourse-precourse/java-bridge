package bridge.model;

import bridge.config.ErrorMessageConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private List<Direction> allowMove = new ArrayList<>();

    /**
     * 다리를 생성 및 초기화한다.
     * @param dirs 위 : "U", 아래 : "D"로 표현된 방향 정보
     * @throws IllegalArgumentException "U", "D" 외의 다른 문자가 포함되거나, 3 이상 20 이하의 길이가 아닌 경우
     */
    public Bridge(List<String> dirs) throws IllegalArgumentException {
        bridgeSizeValidation(dirs.size());
        dirs.forEach(d -> allowMove.add(Direction.of(d)));
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
