package bridge.domain;

import bridge.util.BridgeBlock;
import bridge.util.BridgePosition;
import bridge.util.ErrorMessage;
import bridge.util.GameCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private List<String> movements;
    private int trialCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        trialCount = 1;
        initMovements();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movingPosition) {
        boolean possibleToMove = bridge.isMovable(movingPosition, movements.size());
        movements.add(movingPosition);
        return possibleToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String selectedProgress) {
        if (GameCommand.RETRY.isEqual(selectedProgress)) {
            initMovements();
            trialCount++;
            return true;
        }
        return false;
    }

    public void initMovements() {
        this.movements = new ArrayList<>();
    }

    public List<String> getUpBridgeBlocks() {
        return IntStream.range(0, movements.size())
                .mapToObj(index -> getBlockResult(BridgePosition.UP, index))
                .collect(Collectors.toList());
    }

    public List<String> getDownBridgeBlocks() {
        return IntStream.range(0, movements.size())
                .mapToObj(index -> getBlockResult(BridgePosition.DOWN, index))
                .collect(Collectors.toList());
    }

    public boolean isFinished() {
        return bridge.isEndPoint(movements.size());
    }

    public int getTrialCount() {
        return trialCount;
    }

    private String getBlockResult(BridgePosition bridgePosition, int index) {
        if (bridgePosition.isEqualToBridgePosition(movements.get(index))) {
            return getMovedResult(movements.get(index), index);
        }
        return BridgeBlock.NOT_MOVED.getBlock();
    }

    private String getMovedResult(String movingPosition, int index) {
        if (bridge.isMovable(movingPosition, index)) {
            return BridgeBlock.SUCCESS_MOVED.getBlock();
        }
        return BridgeBlock.FAIL_MOVED.getBlock();
    }
}
