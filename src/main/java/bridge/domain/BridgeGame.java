package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.domain.BridgeGameConstant.START_INDEX;
import static bridge.domain.BridgeStatus.FAIL;
import static bridge.domain.BridgeStatus.SUCCESS;
import static bridge.ui.ViewConstant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RESTART = "R";

    private final List<String> bridge;
    private final BridgeMap bridgeMap;
    private final GameCount gameCount;

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

    private boolean isPossibleCrossBridge(String direction) {
        return this.status = bridge.get(mapCoordinate).equals(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(RESTART)) {
            setUpRetry();
            return true;
        }
        return false;
    }

    private void setUpRetry() {
        setUpCoordinate();
        bridgeMap.setUpMap();
        this.gameCount.increase();
    }

    private void setUpCoordinate() {
        this.mapCoordinate = START_INDEX;
    }

    public boolean checkStatus() {
        return this.status;
    }

    public String getMap() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(bridgeMap.bridgeStatuses).forEach(row -> {
            sb.append(START_BRIDGE_SHAPE);
            sb.append(buildBridge(row));
            sb.append(END_BRIDGE_SHAPE);
        });
        return sb.toString();
    }

    private String buildBridge(BridgeStatus[] row) {
        return Arrays.asList(row).subList(START_INDEX, mapCoordinate)
                .stream()
                .map(bridgeBlockStatus -> bridgeBlockStatus.buildBridge)
                .collect(Collectors.joining(JOINING_DELIMITER));
    }

    public boolean checkWinning() {
        return Result.checkWinning(mapCoordinate, bridge) && this.status;
    }

    public Result getResult() {
        return new Result(getMap(), this.status, gameCount.getGameCount());
    }
}
