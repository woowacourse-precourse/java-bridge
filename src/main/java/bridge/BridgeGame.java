package bridge;

import model.Bridge;
import model.BridgeMaps;
import model.BridgeType;
import model.MoveMark;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgeMaps maps;
    private int stage;
    private boolean status;


    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.maps = new BridgeMaps();
        this.stage = 0;
        this.status = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MoveMark mark) {
        status = bridge.canMove(stage, mark);
        updateBridgeMaps(mark, status);
        updateStage(status);
    }

    private void updateBridgeMaps(MoveMark mark, boolean move) {
        BridgeType type = mark.getBridgeType();
        maps.updateMaps(type, move);
    }

    private void updateStage(boolean move) {
        if (move) {
            stage++;
            return;
        }

        stage = 0;
    }

    public boolean isContinue() {
        return !bridge.isLast(stage) && isSuccess();
    }

    public boolean isSuccess() {
        return status;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        maps.reset();
        status = true;
    }

    public void quit() {
        status = false;
    }
}
