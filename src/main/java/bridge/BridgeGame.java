package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int times = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Player player) {
        if (isWrongDir(player)) {
            return true;
        }
        return false;
    }

    private boolean isWrongDir(Player player) {
        List<String> playerDirs = player.getSelectedBridge();
        int nextBridgeIdx = player.getNextBridge();

        return !Objects.equals(bridge.get(nextBridgeIdx), playerDirs.get(nextBridgeIdx));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String commend) {
        Validator.validateCommend(commend);
        boolean retry = Command.valueOf(commend).getRetry();
        if (retry) {
            times++;
        }
        return retry;
    }

    public boolean isGameLeft(Player player) {
        return player.getNextBridge() < bridge.size() - 1;
    }

    public int getTimes() {
        return times;
    }
}
