package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
//    private String[][] map;

//    private Map<Integer, String> map;

    public BridgeGame(int bridgeSize) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
//        this.map = new String[2][];
//        this.map = new String[2][bridge.size()];
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving, int index) {
        String eachBridge = bridge.get(index);
        String moveResult;
        if (moving.equals(eachBridge)) {
            moveResult = "O";
            return moveResult;
        }
        moveResult = "X";
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
}
