package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> player;
    private final BridgeGameMap bridgeGameMap; // 필드가 많아지지만 브릿지 게임 맵은 게임에 의존적이기 때문에 그냥 필드로 설정
    private int tryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        player = new ArrayList<>();
        bridgeGameMap = new BridgeGameMap();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 플레이어에 움직임을 집어넣고, 맵을 업데이트 시킨다.
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) throws IllegalArgumentException {
        player.add(moving);
        int currentIndex = player.size() - 1;
        bridgeGameMap.updateMap(bridge.get(currentIndex), player.get(currentIndex));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 시도횟수를 증가시키고 맵을 초기화 시킨다.
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.clear();
        tryCount++;
        bridgeGameMap.reset();
    }

    public boolean isEnd() {
        return player.equals(bridge);
    }

    public boolean canStandOnCurrentBridge() {
        int currentIndex = player.size() - 1;
        return player.get(currentIndex).equals(bridge.get(currentIndex));
    }

    public List<List<String>> getMap() {
        return List.of(bridgeGameMap.getUpSide(), bridgeGameMap.getDownSide());
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getPlayer() {
        return player;
    }
}

