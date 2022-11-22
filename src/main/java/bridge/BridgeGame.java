package bridge;

import bridge.view.InputView;

import static bridge.view.InputView.D_INPUT_CLIPPED_WORD;
import static bridge.view.InputView.U_INPUT_CLIPPED_WORD;

public class BridgeGame {

    public void move(Bridge bridge, PlayerStatus playerStatus) {
        String direction = playerStatus.getDirection();
        boolean isMatch = playerStatus.isMatch();

        if (direction.equals(U_INPUT_CLIPPED_WORD)) {
            moveUpper(bridge, isMatch);
            return;
        }
        if (direction.equals(D_INPUT_CLIPPED_WORD)) {
            moveLower(bridge, isMatch);
        }
    }

    private void moveUpper(Bridge bridge, boolean isMatch) {
        if (isMatch) {
            bridge.moveUpperBridge();
            return;
        }
        bridge.cannotMoveUpperBridge();
    }

    private void moveLower(Bridge bridge, boolean isMatch) {
        if (isMatch) {
            bridge.moveLowerBridge();
            return;
        }
        bridge.cannotMoveLowerBridge();
    }

    public boolean retry(final String command) {
        return command.equals(InputView.Q_INPUT_CLIPPED_WORD);
    }
}
