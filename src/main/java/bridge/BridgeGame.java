package bridge;

import java.util.HashMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public String move(String bridge, String moving) {

        if (bridge.equals(moving)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public HashMap<String, Integer> retry(HashMap<String, Integer> gameData) {

        gameData.put("gameCount", gameData.get("gameCount")+1);
        gameData.put("index", 0);

        return gameData;
    }
}
