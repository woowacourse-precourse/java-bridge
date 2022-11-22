package bridge;

import bridge.constant.Token;
import bridge.domain.Bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private BridgeMaker maker;
    private int count;

    public BridgeGame() {
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) {
        return bridge.update(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput.equals(Token.RESTART.getMark())) {
            bridge.reset();
            count++;
            return true;
        }
        return false;
    }

    public void start(int size) {
        bridge = new Bridge(maker.makeBridge(size));
    }

    public List<BridgeInfo> getUpperBridge() {
        return bridge.getBridgeInfo(Token.UP.getMark());
    }

    public List<BridgeInfo> getLowerBridge() {
        return bridge.getBridgeInfo(Token.DOWN.getMark());
    }

    public boolean isClear() {
        return bridge.isClear();
    }

    public int getCount() {
        return count;
    }
}
