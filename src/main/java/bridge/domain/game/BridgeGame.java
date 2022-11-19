package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;
import bridge.domain.mapmaker.MapMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<Direction> currentPath;
    private final MapMaker maker;

    public BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
        this.currentPath = new ArrayList<>();
        this.maker = new MapMaker();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public CrossStatus move(final Direction direction) {
        currentPath.add(direction);

        CrossStatus result = bridge.cross(currentPath);

        makeMap(direction, result);

        return result;
    }

    private void makeMap(final Direction direction,
                         final CrossStatus result) {
        maker.addPath(direction, result);
    }

    /**
     * 현재까지 사용자가 입력한 값을 통해 그려진 지도 반환
     */
    public String currentMap() {
        return maker.getCurrentMap();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.currentPath.clear();
        this.maker.init();
    }

    public CrossStatus status() {
        return bridge.cross(currentPath);
    }
}
