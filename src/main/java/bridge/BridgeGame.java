package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private List<String> inputDirections = new ArrayList<>();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public List<String> getInputDirections() {
        return inputDirections;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return 클리어: Result.CLEAR 게임오버: Result.WRONG 맞춤: Result.SAME;
     */
    public Result move(String s) {
        inputDirections.add(s);
        if (bridge.isCleared(inputDirections)) {
            return Result.CLEAR;
        }
        if (bridge.isCorrect(inputDirections)) {
            return Result.SAME;
        }
        return Result.WRONG;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        inputDirections = new ArrayList<>();
    }
}
