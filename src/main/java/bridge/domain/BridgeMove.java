package bridge.domain;

import bridge.model.Player;
import bridge.view.InputView;

public class BridgeMove {
    public void movePlayer(Player player) {
        String moveTo = InputView.getInputView().readMoving();
        player.setPosition(moveTo);
    }
}
