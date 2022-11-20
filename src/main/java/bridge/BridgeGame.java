package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> movingData = new ArrayList<>();
    private final List<Boolean> movingResults = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param moving
     * @param block
     * @return
     */
    public boolean move(String moving, String block) {
        Boolean movingResult = Objects.equals(moving, block);

        movingData.add(moving);
        movingResults.add(movingResult);
        return movingResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public String findMovingByIndex(int index) {
        return movingData.get(index);
    }

    public Boolean findMovingResultByIndex(int index) {
        return movingResults.get(index);
    }

    public int getCountOfMovingResults() {
        return movingResults.size();
    }
}
