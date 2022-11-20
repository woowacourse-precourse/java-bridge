package bridge.model;

import static bridge.controller.InputController.getUserSelection;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final FinalResult finalResult;


    public BridgeGame(Bridge bridge, FinalResult finalResult) {
        this.bridge = bridge;
        this.finalResult = finalResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Diagram diagram) {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            String position = getUserSelection();
            if (!bridge.isSamePosition(index, position)) {
                diagram.updateDiagrams(position, Status.DIE);
                break;
            }
            diagram.updateDiagrams(position, Status.SURVIVE);
            handleSuccess(index);
        }
    }

    private void handleSuccess(int index) {
        if (bridge.survivedToTheLast(index)) {
            finalResult.setSuccess();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        return finalResult.retry();
    }

}
