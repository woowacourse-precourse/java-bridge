package bridge.controller;

import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final User user;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        user = new User(new BridgeRandomNumberGenerator());
    }

    public void playGame() {
        do {
            if (!move()) {
                retry();
            }
        } while (!user.isEnd());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move() {
        return user.move();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        user.retry();
    }
}
