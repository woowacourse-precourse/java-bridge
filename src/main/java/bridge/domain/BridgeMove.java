package bridge.domain;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;

import static bridge.util.BridgeConstant.FALL_BLOCK;

public class BridgeMove {
    public void movePlayer(Player player) {
        String moveTo = InputView.getInputView().readMoving();
        player.setPosition(moveTo);
    }

    public boolean getMoveSuccess(Player player, Bridge bridge) {
        int positionX = player.getXPosition();
        int positionY = player.getYPosition();
        return !bridge.getBridge()[positionY][positionX].equals(FALL_BLOCK);
    }
}
