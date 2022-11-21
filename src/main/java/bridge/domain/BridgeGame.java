package bridge.domain;

import bridge.util.BridgeBlock;
import bridge.util.BridgePosition;
import bridge.util.GameCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeGame {

    private final Bridge bridge;
    private List<String> movements;
    private int trialCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        trialCount = 1;
        initMovements();
    }

    public boolean move(String movingPosition) {
        boolean possibleToMove = bridge.isMovable(movingPosition, movements.size());
        movements.add(movingPosition);
        return possibleToMove;
    }

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

    public List<String> getUpBridgeResult() {
        return IntStream.range(0, movements.size())
                .mapToObj(index -> getBlockResult(BridgePosition.UP, index))
                .collect(Collectors.toList());
    }

    public List<String> getDownBridgeResult() {
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
