package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> upResult;
    private final List<String> downResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upResult = new ArrayList<>();
        this.downResult = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(int round, String moving) {
        String[] result = {"   ", "   "};
        String current = bridge.get(round);
        BridgeType bridgeByMoving = BridgeType.valueOfString(moving);
        result[bridgeByMoving.getNumber()] = " X ";
        if (Objects.equals(moving, current)) {
            result[bridgeByMoving.getNumber()] = " O ";
        }
        addGameResult(result);
        return Arrays.asList(upResult, downResult);
    }

    public void addGameResult(String[] result) {
        upResult.add(result[1]);
        upResult.add("|");
        downResult.add(result[0]);
        downResult.add("|");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
