package bridge.model;

import static bridge.util.Constants.INITIAL_ATTEMPTS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int attempts = INITIAL_ATTEMPTS;
    private SuccessAndFail successAndFail = SuccessAndFail.FAIL;
    private Diagram diagram = new Diagram();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public SurviveAndDie move(int index, Position position) {
        SurviveAndDie surviveAndDie = SurviveAndDie.from(bridge.isSamePosition(index, position));
        diagram.updateDiagrams(position, surviveAndDie);
        return surviveAndDie;
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

    public SuccessAndFail successOrFail() {
        return successAndFail;
    }

    public void setSuccess() {
        this.successAndFail = SuccessAndFail.SUCCESS;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
