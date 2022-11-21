package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void run() {
        move(createBridge());
    }

    public List<String> createBridge() {
        int bridgeSize = new BridgeSize().get();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge) {
        List<String> compareResult = new ArrayList<>();
        for (int space = 0; space < bridge.size(); space++) {
            String OX = compare(bridge.get(space));
            compareResult.add(OX);
            MoveResult moveResult = new MoveResult(compareResult);
        }
    }

    public String compare(String eachBridgeSpace) {
        if (eachBridgeSpace == new Moving().get())
            return "O";
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
