package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> movingData = new ArrayList<>();
    private final List<Boolean> movingResults = new ArrayList<>();

    private int totalAttempts = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param moving
     * @param block
     * @return
     */
    public void move(String moving, String block) {
        movingData.add(moving);
        movingResults.add(Objects.equals(moving, block));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movingData.clear();
        movingResults.clear();
        totalAttempts++;
    }

    public String findMovingByIndex(int index) {
        return movingData.get(index);
    }

    public Boolean findMovingResultByIndex(int index) {
        return movingResults.get(index);
    }

    public int getMovingCount() {
        return movingResults.size();
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public boolean canMoveMoreBlock(int length) {
        return length > movingData.size();
    }

    public boolean isMovingFail() {
        return movingResults.contains(false);
    }
}
