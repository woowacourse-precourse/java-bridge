package bridge.service;

import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RETRY_COMMAND = "R";

    private final InputView inputView = new InputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    private void isCorrectCell(String answer, String command) {
        if (answer.equals(command)) {
            return;
        }

        retry();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        String command = inputView.readGameCommand();

        if (command.equals(RETRY_COMMAND)) {
            move();
        }
    }
}
