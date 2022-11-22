package model;

import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String BRIDGE_CHECK = "U";
    private static final String GAME_RETRY = "R";

    private HashMap<Integer, Boolean> upBridge = new HashMap<>();
    private HashMap<Integer, Boolean> downBridge = new HashMap<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(List<String> crossAble, int turn, String move) {
        Boolean matchResult = crossAble.get(turn).equals(move);
        if (move.equals(BRIDGE_CHECK)) {
            upBridgeStore(matchResult, turn);
            return matchResult;
        }
        downBridgeStore(matchResult, turn);
        return matchResult;
    }

    private void upBridgeStore(Boolean match, int turn) {
        upBridge.put(turn, match);
        if (!downBridge.containsKey(turn)) {
            downBridge.put(turn, null);
        }
    }

    private void downBridgeStore(Boolean match, int turn) {
        downBridge.put(turn, match);
        if (!upBridge.containsKey(turn)) {
            upBridge.put(turn, null);
        }
    }

    public HashMap<Integer, Boolean> getUpBridge() {
        return upBridge;
    }

    public HashMap<Integer, Boolean> getDownBridge() {
        return downBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(String gameCommand) {
        return gameCommand.equals(GAME_RETRY);
    }
}
