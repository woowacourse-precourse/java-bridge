package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, String input) {
        bridge.getCrossed().add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isCorrect(Bridge bridge) {
        List<String> footholds = bridge.getFootholds();
        List<String> crossed = bridge.getCrossed();
        int lastFootholdIndex = bridge.getCrossed().size() - 1;

        if (!crossed.get(lastFootholdIndex).equals(footholds.get(lastFootholdIndex))) {
            return false;
        }
        return true;
    }

    public boolean isAllCrossed(Bridge bridge) {
        int footholdsSize = bridge.getFootholds().size();
        int crossedSize = bridge.getCrossed().size();

        if (footholdsSize == crossedSize) {
            return true;
        }
        return false;
    }

    public void resetCrossed(Bridge bridge) {
        bridge.setCrossed(Arrays.asList());
    }

    public void increaseTried(Bridge bridge) {
        bridge.setTried(bridge.getTried() + 1);
    }

    public boolean isClear(Bridge bridge) {
        if (!isAllCrossed(bridge)) {
            return false;
        }
        for (int i = 0; i < bridge.getCrossed().size(); i++) {
            if (!bridge.getFootholds().get(i).equals(bridge.getCrossed().get(i))) {
                return false;
            }
        }
        return true;
    }
}
