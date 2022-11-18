package controller.services;

import bridge.constants.BridgeConstant;
import bridge.constants.CommandTable;
import model.Bridge;
import model.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;
    private int position;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
        position = -1;
    }

    public boolean move(String direction) {
        position++;

        if (bridge.isAccessibleDirection(direction, position)) {
            user.markPosition(direction);
            return false;
        }

        user.markPosition(BridgeConstant.WRONG_POSITION + direction);
        return true;
    }

    public int retry(String retryInput) {
        if (retryInput.equals(CommandTable.QUIT.getCommand())) {
            return CommandTable.QUIT.getCommandNumber();
        }
        return CommandTable.RETRY.getCommandNumber();
    }

}
