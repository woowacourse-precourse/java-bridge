package bridge;

import bridge.enums.BridgeMove;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridges gameBridges;
    private int gameTryCount;

    public BridgeGame(List<String> bridges) {
        this.gameBridges = new Bridges(bridges);
        this.gameTryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(BridgeMove moving) {
        if (this.isCleared()) {
            return false;
        }
        return gameBridges.tryPass(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameBridges.init();
        ++gameTryCount;
    }

    public boolean isCleared() {
        return gameBridges.isAllPassed();
    }

    public int getTryCount() {
        return this.gameTryCount;
    }

    public Bridges getGameBridges() {
        return this.gameBridges;
    }
}
