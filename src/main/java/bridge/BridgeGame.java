package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public boolean checkSame(List<String> RandomBridgeMap, int idx, String playrerStep) {
        if (!RandomBridgeMap.get(idx).equals(playrerStep)) {
            return true;
        }
        return false;
    }

    public void moveWrongWay(List<String> playerBridgeMap, String OpenWay) {
        if (OpenWay.equals("U")) {
            playerBridgeMap.add("fail D");
        }
        if (OpenWay.equals("D")) {
            playerBridgeMap.add("fail U");
        }
    }

    public void move(List<String> playerBridgeMap, List<String> RandomBridgeMap, int idx, String playerStep) {
        if (checkSame(RandomBridgeMap,idx, playerStep)) {
            playerBridgeMap.add(RandomBridgeMap.get(idx));
            return;
        }
        moveWrongWay(playerBridgeMap, RandomBridgeMap.get(idx));
    }

    public boolean retry(String _input) {
        if (_input.equals("R")) {
            return true;
        }
        return false;
    }
}
