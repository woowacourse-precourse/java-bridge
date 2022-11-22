package bridge.data;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final UserBridge userBridge = new UserBridge();

    private boolean correct;

    public void saveBridge(List<String> bridgeResult) {
        bridge = new Bridge(bridgeResult);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public UserBridge move(int count, String userMove) {
        correct = bridge.state(count, userMove);
        userBridge.makeUpBridge(userMove, correct);
        userBridge.makeDownBridge(userMove, correct);
        return userBridge;
    }

    public boolean getCorrect() {
        return correct;
    }

    public UserBridge getUserBridge() {
        return userBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry() {
        userBridge.makeClearUpBridge();
        userBridge.makeClearDownBridge();
        return 1;
    }
}
