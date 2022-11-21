package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static List<String> playerStep = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String step) {
        playerStep.add(step);
        return CheckStep();
    }

    private static boolean CheckStep() {
        int index = playerStep.size() - 1;
        String lastMove = playerStep.get(index);

        if(Application.bridge.get(index).equals(lastMove))
            return true;

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retry) {
        if(Retry.checkRetry(retry)) {
            playerStep = new ArrayList<>();
            return true;

        }

        return false;
    }
}
