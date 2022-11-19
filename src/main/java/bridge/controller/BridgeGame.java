package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Command;
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

    public void retry(UserState userState, Bridge bridge) {
        while (!userState.isQuit()) {
            userState.resetMove();
            userState.tryCountIncrease();
            move(userState, bridge);
            if (userState.isSuccessOrFail(bridge.getSize())) {
                return;
            }
            userState.quitChange(inputView.readGameCommand().equals(Command.QUIT.getCommand()));
        }
    }
}
