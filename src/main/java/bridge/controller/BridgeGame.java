package bridge.controller;

import bridge.domain.enums.Command;
import bridge.domain.UserState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private boolean quit;

    public BridgeGame() {
        this.quit = false;
    }

    public void move(UserState userState, boolean isSafe, String userChoice) {
        if (userChoice.equals(Command.UP.getCommand())) {
            userState.moveToUp(moveOrFall(isSafe));
            return;
        }
        userState.moveToDown(moveOrFall(isSafe));
    }

    private String moveOrFall(boolean isSafe) {
        if (isSafe) {
            return "O";
        }
        return "X";
    }

    public void retry(UserState userState) {
        userState.resetMove();
        userState.tryCountIncrease();
    }

    public boolean isQuit() {
        return quit;
    }

    public void quitChange(boolean retry) {
        quit = retry;
    }
}
