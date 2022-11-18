package controller.services;

import constants.BridgeConstant;
import constants.CommandTable;
import model.Bridge;
import model.User;

public class BridgeGame {
    private Bridge bridge;
    private User user;
    private int movingDistance = -1;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
    }

    public boolean move(String direction) {
        movingDistance++;

        if (bridge.isAccessiblePosition(movingDistance, direction)) {
            user.markPosition(direction);
            return false;
        }

        user.markPosition(BridgeConstant.WRONG_DIRECTION_INITIAL + direction);
        return true;
    }

    public int retry(String retryInput) {
        if (retryInput.equals(CommandTable.QUIT.getInitial())) {
            return CommandTable.QUIT.getCommandNumber();
        }
        return CommandTable.RETRY.getCommandNumber();
    }
}
