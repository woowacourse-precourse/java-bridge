package bridge.domain;

import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static List<MoveResult> move(Bridge bridge, List<MoveResult> moveResults) {
        MoveSpace moveSpace = InputController.getMoving();
        moveResults.add(moveSpace.createMoveResult(bridge.checkIfItCanBeMoved(moveSpace)));
        for (int i = 0; i < moveResults.size(); i++) {
            System.out.print(i);
            moveResults.get(i).pringMoveResult(moveResults.get(i));
        }

        System.out.println(moveResults);
        return moveResults;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge) {
        BridgeGameController.runGame(bridge);
    }
}
