package bridge.service;

import bridge.domain.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private GameStatus gameStatus;
    private MapPrinter mapPrinter;

    public BridgeGame(Bridge bridge, GameStatus gameStatus, MapPrinter mapPrinter) {
        this.bridge = bridge;
        this.gameStatus = gameStatus;
        this.mapPrinter = mapPrinter;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MapPrinter move(Position position, Bridge bridge, BridgeIndex bridgeIndex) {
        mapPrinter.move(position, bridge.isEquals(position, bridgeIndex.getIndex()));
        return mapPrinter;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(MapPrinter mapPrinter, RepeatCount repeatCount) {
        mapPrinter.init();
        repeatCount.increment();
    }
}
