package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final List<String> bridge;
    public int trying = 1;

    public BridgeGame(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
        System.out.println("bridge = " + bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int position) {
        String actual = bridge.get(position);
        if (actual.equals(moving)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retry) {
        if (retry.equals(Input.RETRY.toString())) {
            trying += 1;
            return true;
        }
        return false;
    }

    public int getSize() {
        return bridge.size();
    }
}
