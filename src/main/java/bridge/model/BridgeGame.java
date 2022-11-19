package bridge.model;

import static bridge.controller.InputController.setUserSelection;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }
    // BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
    // BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다
    // BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    // 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        int attemptsNumber = 1;
        int index;
        for (index = 0; index < bridge.getBridgeSize(); index++) {
            if (bridge.isUserSelectionCorrect(setUserSelection(), bridge.currentBridge(index))) {
                continue;
            }
            break;
        }
        if (index == bridge.getBridgeSize()) {
            System.out.println("성공");
        }
        if (index < bridge.getBridgeSize()) {
            System.out.println("실패");
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
