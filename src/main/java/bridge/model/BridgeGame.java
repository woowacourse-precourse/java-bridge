package bridge.model;

import static bridge.controller.InputController.setUserSelection;
import static bridge.model.Diagram.printDiagrams;
import static bridge.model.Diagram.updateDiagram;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int attemptsNumber;
    private boolean finalSuccess;

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
        attemptsNumber = 1;
        finalSuccess = false;
        int index;
        for (index = 0; index < bridge.getBridgeSize(); index++) {
            String position = setUserSelection();
            if (bridge.isUserSelectionCorrect(position, bridge.currentBridge(index))) {
                // 한 칸 이동 성공 (survive)
                // O을 보내서 다이어그램 출력
                updateDiagram(position, Status.SURVIVE);
                printDiagrams();
                continue;
            }
            // 한 칸 이동 실패 (death)
            // X을 보내서 다이어그램 출력
            updateDiagram(position, Status.DIE);
            printDiagrams();
            break;
        }
        if (index == bridge.getBridgeSize()) {
            // 성공 처리 (success)
            finalSuccess = true;
            // 최종 게임 결과 (다리의 전체 다이어그램, 성공 여부, 시도 횟수 출력)

        }
        if (index < bridge.getBridgeSize()) {
            System.out.println("실패");
            // 실패 처리 (fail)
            // 게임 재시작 or 종료 선택
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }

    public boolean isFinalSuccess() {
        return finalSuccess;
    }
}
