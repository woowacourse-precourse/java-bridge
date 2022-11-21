package bridge;

import model.Bridge;
import model.BridgeMaps;
import model.BridgeType;
import model.GameResult;
import model.MoveMark;
import model.ResultType;
import model.TryCount;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgeMaps maps;
    private final TryCount count;
    private final GameResult result;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.maps = new BridgeMaps();
        this.count = new TryCount();
        this.result = new GameResult();
    }

    public Map<BridgeType, List<String>> getMaps() {
        return maps.getMaps();
    }

    public int getTryCount() {
        return count.getCount();
    }

    public ResultType getGameResult() {
        return result.getResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MoveMark mark) {
        boolean move = bridge.canMove(getStage(), mark);
        updateBridgeMaps(mark, move);
        updateGameResult(move);
    }

    private int getStage() {
        return maps.getStage();
    }

    private void updateBridgeMaps(MoveMark mark, boolean move) {
        BridgeType type = mark.getMark();
        maps.updateMaps(type, move);
    }

    private void updateGameResult(boolean move) {
        result.update(move);
    }

    public boolean isContinue() {
        return !bridge.isLast(getStage()) && isSuccess();
    }

    public boolean isSuccess() {
        return result.isRun();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        maps.reset();
        result.reset();
        count.increase();
    }
}
