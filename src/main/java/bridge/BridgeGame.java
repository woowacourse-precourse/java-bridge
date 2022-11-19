package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
//    final private BridgeMaker bridgeMaker;
//    final private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
//    final private Bridge bridge;
    private List<String> user;
    private int tryCount;
//
//    public BridgeGame(int size) {
//        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
//        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
//        bridge = new Bridge(bridgeMaker.makeBridge(size));
//        user = new ArrayList<>();
//        tryCount = 1;
//    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingCommand) {
        user.add(movingCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.clear();
        tryCount++;
    }

    public String createResult(Bridge bridge) {
        String result = " ";
        return result;
    }
}
