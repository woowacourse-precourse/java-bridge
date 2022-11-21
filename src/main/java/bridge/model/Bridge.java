package bridge.model;

import java.util.List;

public class Bridge {

    private List<Direction> allowMove;

    /**
     * 다리를 생성 및 초기화한다.
     * @param dirs 위 : "U", 아래 : "D"로 표현된 방향 정보
     */
    public Bridge(List<String> dirs) {
        dirs.forEach(d -> allowMove.add(Direction.of(d)));
    }
}
