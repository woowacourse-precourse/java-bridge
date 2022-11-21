package bridge.model;

import static bridge.model.Status.findStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int attempts = 1;
    private boolean success = false;
    private Diagram diagram;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        diagram = new Diagram();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Status move(int index, Position position) {
        Status status = findStatus(bridge.isSamePosition(index, position));
        diagram.updateDiagrams(position, status);
        return status;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        diagram = new Diagram();
        attempts++;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess() {
        this.success = true;
    }

    public Diagram getDiagram() {
        return diagram;
    }

}
