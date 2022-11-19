package bridge.domain;

import bridge.model.Player;
import bridge.view.InputView;

public class BridgeMove {
    InputView inputView = InputView.getInputView();

    public void movePlayer(Player player) {
        String moveTo = inputView.readMoving();
        player.setPosition(moveTo);
    }
}
