package bridge.domain.PlayerMove;

import bridge.view.InputView;

public class PlayerMove {
    public static String takeMovingPosition() {
        InputView inputView = new InputView();
        String movingPosition = inputView.readMoving();

        return movingPosition;
    }
}
