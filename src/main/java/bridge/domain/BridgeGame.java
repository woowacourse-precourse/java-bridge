package bridge.domain;

import static bridge.util.Messages.*;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {
    
    private final int retryCount;
    private final boolean gameFlag;

    public BridgeGame(int retryCount, boolean gameFlag) {
        this.retryCount = retryCount;
        this.gameFlag = gameFlag;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean getGameFlag() {
        return gameFlag;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> move(CompareBridge playerMove, List<String> upSideDownSideMove, String bridgeElement) {
        upSideDownSideMove.set(0, upSideDownSideMove.get(0)
                + playerMove.getUpSideMove(playerMove, bridgeElement).toString());
        upSideDownSideMove.set(1, upSideDownSideMove.get(1)
                + playerMove.getDownSideMove(playerMove, bridgeElement).toString());
        return upSideDownSideMove;
    }

    public boolean isFailure(List<String> upSideDownSideMove) {
        return upSideDownSideMove.stream()
                .anyMatch(move -> move.contains(INCORRECT) || move.isBlank());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame retry(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            return new BridgeGame(retryCount + 1, true);
        }
        return new BridgeGame(retryCount, false);
    }
}
