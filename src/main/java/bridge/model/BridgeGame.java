package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int position;
    private long playTime;
    public List<String> gameMap;

    public BridgeGame(List<String> gameMap) {
        this.gameMap = gameMap;
        position = 0;
        playTime = 1;
        System.out.println(gameMap);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        if (gameMap.get(position).equals(input)) {
            position++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public long retry() {
        position = 0;
        playTime++;
        return playTime;
    }

    public boolean isClear() {
        return position >= gameMap.size();
    }
}
