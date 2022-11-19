package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.UserState;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void move(UserState userState, Bridge bridge) {
        while (userState.getStep() < bridge.getSize()) {
            String userChoice = inputView.readMoving();
            boolean isSafe = bridge.isSafe(userState.getStep(), userChoice);
            userState.moveToNext(isSafe, userChoice);
            outputView.printMap(userState.toString());
            if (!isSafe) {
                return;
            }
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
