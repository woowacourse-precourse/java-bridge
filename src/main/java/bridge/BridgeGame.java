package bridge;

import java.util.ArrayList;
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
    public boolean move(List<String> bridge, List<String> userPosition, String move) {
        userPosition.add(move);
        return isCorrectStep(bridge, userPosition);
    }

    public boolean isCorrectStep(List<String> bridge, List<String> userPosition) {
        for (int i = 0; i < userPosition.size(); i++) {
            if (!userPosition.get(i).equals(bridge.get(i)))
                return false;
        }
        return true;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        // 비교하여 t/f 반환하기
        if (command.equals("R"))
            return true;
        if (command.equals("Q"))
            return false;
        throw new IllegalArgumentException("[ERROR] 재시도 여부는 (재시도: R, 종료: Q)의 값이어야 합니다.");
    }
}
