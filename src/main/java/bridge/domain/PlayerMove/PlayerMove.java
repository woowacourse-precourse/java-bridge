package bridge.domain.PlayerMove;

import bridge.view.InputView;

public class PlayerMove {
    public static String takeMovingPosition() {
        InputView inputView = new InputView();
        String movingPosition = inputView.readMoving();

        try {
            PlayerMoveValidator.validate(movingPosition);
            return movingPosition;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeMovingPosition();
        }
    }
}
