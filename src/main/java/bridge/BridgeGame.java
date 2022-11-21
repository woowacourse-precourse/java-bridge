package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public enum GameStatus {
        WIN("WIN"),
        SAFE("SAFE"),
        R("RETRY");
        private String status;
        private GameStatus(String status) {
            this.status = status;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, String moving, int gameNumber) {
        if (isSafePlate(moving, bridge.get(gameNumber))) {
            if (isGameWin(bridge.size(), gameNumber)) {
                return GameStatus.WIN.status;
            }
            return GameStatus.SAFE.status;
        }
        return retry();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        return GameStatus.R.status;
    }

    private boolean isSafePlate(String moving, String bridge) {
        if (moving.equals(bridge)) {
            return true;
        }
        return false;
    }

    private boolean isGameWin(int bridgeSize, int gameNumber) {
        if ((bridgeSize - 1) == gameNumber) {
            return true;
        }
        return false;
    }
}
