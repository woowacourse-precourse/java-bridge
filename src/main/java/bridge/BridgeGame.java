package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public boolean check_same(List<String> RandomBridgeMap, int idx, String playrerStep) {
        if (!RandomBridgeMap.get(idx).equals(playrerStep)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean checkMove(String OpenWay, String nextStep) {
        if (OpenWay.equals(nextStep)) {
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
        String OpenWay = RandomBridgeMap.get(idx);
        if (checkMove(OpenWay, playerStep)) {
            playerBridgeMap.add(OpenWay);
            return;
        }
        moveWrongWay(playerBridgeMap, OpenWay);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
