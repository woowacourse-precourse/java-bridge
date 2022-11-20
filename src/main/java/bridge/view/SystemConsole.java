package bridge.view;

import bridge.constants.SystemMessage;

public class SystemConsole {

    public void nextLine() {
        System.out.println();
    }

    public void gameStartMessage() {
        System.out.println(SystemMessage.BRIDGE_GAME_START);
        System.out.println();
    }

    public void bridgeLength() {
        System.out.println(SystemMessage.BRIDGE_LENGTH_INPUT);
    }

    public void movementInput() {
        System.out.println(SystemMessage.MOVEMENT_INPUT);
    }

    public void gameRestartEnd() {
        System.out.println(SystemMessage.GAME_RESTART_END);
    }

    public void lastGameResult() {
        System.out.println(SystemMessage.LAST_GAME_RESULT);
    }

    public void gameSuccess() {
        System.out.println(SystemMessage.GAME_SUCCESS);
    }

    public void gameFailure() {
        System.out.println(SystemMessage.GAME_FAILURE);
    }

    public void allTryCount(int count) {
        System.out.println(SystemMessage.ALL_TRY_COUNT + count);
    }
}
