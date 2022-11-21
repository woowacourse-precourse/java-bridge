package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public BridgeGame() {
        Player.set();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeGameHost bridgeGameHost, String direction) {
        Player.moving();

        if (!bridgeGameHost.stepOfIndexInBridge(Player.getIndex()).equals(direction)) { // 만일 틀리면
            Player.dead();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(BridgeGameHost bridgeGameHost) {
        Player.revive();
    }
}
