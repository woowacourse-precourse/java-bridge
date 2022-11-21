package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void run() {
        move(createBridge());
    }

    public List<String> createBridge() {
        int bridgeSize = new BridgeSize().get();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge) {
        Map<String, String> gameResult = new HashMap<>();
        for (int space = 0; space < bridge.size(); space++) {
            String direction = gameResult.get(space);
            String result = compareMoving(direction);
            addGameResult(gameResult, direction, result);
            MoveResult moveResult = new MoveResult(gameResult);
        }
    }

    public String compareMoving(String eachBridgeSpace) {
        if (eachBridgeSpace == new Moving().get())
            return "O";
        return "X";
    }

    public Map<String, String> addGameResult(Map<String, String> gameResult, String direction, String result) {
        if (direction == "U") {
            gameResult.put("U", gameResult.get("U") + result);
            gameResult.put("D", gameResult.get("D") + " ");
            return gameResult;
        }
        gameResult.put("U", gameResult.get("U") + " ");
        gameResult.put("D", gameResult.get("D") + result);
        return gameResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
