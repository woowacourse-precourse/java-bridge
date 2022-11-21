package bridge.domain;

import java.util.List;

import static bridge.domain.BridgeGameConstant.START_INDEX;
import static bridge.domain.BridgeStatus.FAIL;
import static bridge.domain.BridgeStatus.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final GameCount gameCount;
    private final BridgeMap bridgeMap;

    private boolean status;
    private int mapCoordinate;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeMap = new BridgeMap(bridge.size());
        gameCount = GameCount.start();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (isPossibleCrossBridge(direction)) {
            bridgeMap.reflectAtMap(direction, mapCoordinate, SUCCESS);
        }
        if (!isPossibleCrossBridge(direction)) {
            bridgeMap.reflectAtMap(direction, mapCoordinate, FAIL);
        }
        mapCoordinate++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        setUpRetry();
    }

    private boolean isPossibleCrossBridge(String direction) {
        return this.status = bridge.get(mapCoordinate).equals(direction);
    }

    private void setUpRetry() {
        setUpCoordinate();
        bridgeMap.setUpMap();
        this.gameCount.increase();
    }

    private void setUpCoordinate() {
        this.mapCoordinate = START_INDEX;
    }

    public boolean isContinueStatus() {
        return this.status && !this.isWinningGame();
    }

    public boolean isRetryable() {
        return !this.status;
    }

    private boolean isWinningGame() {
        return Result.checkWinning(mapCoordinate, bridge) && this.status;
    }

    public Result getResult() {
        return new Result(this);
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public GameCount getGameCount() {
        return gameCount;
    }

    public boolean isStatus() {
        return status;
    }

    public int getMapCoordinate() {
        return mapCoordinate;
    }
}
