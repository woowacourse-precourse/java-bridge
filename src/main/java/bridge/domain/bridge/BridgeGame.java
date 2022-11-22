package bridge.domain.bridge;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int turn;
    private int tries;
    BridgeMap bridgeMap;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tries = 1;
        initState();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        boolean isCorrect = checkValue(direction);
        bridgeMap.add(direction, isCorrect);
        this.turn ++;
        return isCorrect;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initState();
        this.tries ++;
    }

    public BridgeMap getBridgeMap() {
        return this.bridgeMap;
    }

    public int getTries() {
        return this.tries;
    }

    public boolean checkEnd() {
        return this.turn == this.bridge.size();
    }

    private void initState() {
        this.turn = 0;
        this.bridgeMap = new BridgeMap();
    }
    private boolean checkValue(String direction) {
        String answer = this.bridge.get(this.turn);
        return direction.equals(answer);
    }
}
