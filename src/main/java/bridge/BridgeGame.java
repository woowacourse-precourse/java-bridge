package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int totalAttempt = 1;
    private List<String> bridge;
    private List<String> history = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }
//    private Bridge bridge;
//
//    public BridgeGame(Bridge bridge){
//        this.bridge = bridge;
//    }


    public int getTotalAttempt() {
        return totalAttempt;
    }

    public List<String> getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(char moveCommand) {
        history.add(String.valueOf(moveCommand));
        return getMoveResult();
    }

    private MoveResult getMoveResult() {
        int idx = history.size() - 1;

        if (history.equals(bridge)) {
            return new MoveResult(history, GameStatus.CORRECT);
        }
        if (history.get(idx).equals(bridge.get(idx))) {
            return new MoveResult(history, GameStatus.CONTINUE);
        }
        return new MoveResult(history, GameStatus.FAIL);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        totalAttempt++;
        history = new ArrayList<>();
    }
}
