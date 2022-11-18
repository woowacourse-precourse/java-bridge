package bridge.controller;

import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;

public class BridgeGameController {
    public void move() {
            String movingDirection = InputView.readMoving();

            try {
                MovingDirectionValidator.validateDirection(movingDirection);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                move();
        }
    }
}
