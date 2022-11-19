package bridge.domain;

import static bridge.controller.BridgeGameController.restartGame;

import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    private static final String MOVE_SUCCESS = "O";
    private static final String MOVE_FAIL = "X";
    private static final String RESTART = "R";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String bridge, String inputDirection) {
        if (bridge.equals(inputDirection)) {
            return MOVE_SUCCESS;
        }
        return MOVE_FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String moveResult) {
        if (moveResult.equals("X")) {
            String input = inputView.inputGameRestart();
            if (input.equals(RESTART)) {
                restartGame();
            }
        }
    }
}
