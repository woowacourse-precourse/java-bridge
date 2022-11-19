package bridge.domain;

import static bridge.domain.BridgeMapConstant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RESTART = "R";

    private final Bridge bridge;
    private final GameCount gameCount;

    private boolean status;
    private int mapCoordinate = START_INDEX;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        gameCount = new GameCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(String direction) {
        if (checkCrossBridge(direction, mapCoordinate)) {
            return getCurrentMap(this.status = true);

        }
        return getCurrentMap(this.status = false);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(RESTART)) {
            gameInit();
            return true;
        }
        return false;
    }

    private void gameInit() {
        initializeMapCount();
        gameCount.increase();
    }

    private boolean checkCrossBridge(String direction, int count) {
        this.mapCoordinate++;
        return this.bridge.getBridge().get(count).equals(direction);
    }

    private void initializeMapCount() {
        this.mapCoordinate = START_INDEX;
    }

    public boolean checkStatus() {
        return status;
    }

    public boolean isWinningBrideGame() {
        return Result.checkWinning(mapCoordinate, bridge);
    }

    public Result getResult() {
        return new Result(getCurrentMap(status), status, gameCount.getGameCount());
    }

    private BridgeMap getCurrentMap(boolean status) {
        return new BridgeMap(bridge, mapCoordinate, status);
    }
}
