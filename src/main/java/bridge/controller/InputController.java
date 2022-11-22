package bridge.controller;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.DirectionValidator;
import bridge.GameCommend;
import bridge.validator.GameCommendValidator;
import bridge.view.InputView;

public class InputController {

    private final InputView inputView;

    public InputController(final InputView inputView) {
        this.inputView = inputView;
    }

    public int setBridgeSize() {
        try {
            BridgeSizeValidator validator
                = new BridgeSizeValidator(inputView.readBridgeSize());
            return validator.getBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public String setMovingDirection() {
        try {
            DirectionValidator validator
                = new DirectionValidator(inputView.readMoving());
            return validator.getDirection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setMovingDirection();
        }
    }

    public GameCommend setGameCommend() {
        try {
            GameCommendValidator validator
                = new GameCommendValidator(inputView.readGameCommand());
            return validator.getCommend();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setGameCommend();
        }
    }
}
