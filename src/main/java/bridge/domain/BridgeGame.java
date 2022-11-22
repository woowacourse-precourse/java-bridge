package bridge.domain;

import bridge.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        String movingResult = getMovingResult(moving);
        player.move(movingResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.retry();
    }

    public boolean isEnd() {
        int bridgeSize = bridge.getBridgeSize();
        int movingPosition = player.getMovingPosition();
        return bridgeSize == movingPosition;
    }

    private String getMovingResult(String moving) {
        int movingPosition = player.getMovingPosition();
        String movingBridgeShape = bridge.getBridgeShapeByPosition(movingPosition);

        if (movingBridgeShape.equals(moving)) {
            return Result.SUCCESS.getCharacter();
        }
        return Result.FAILURE.getCharacter();
    }
}
