package bridge.controller;

import bridge.service.PlayerService;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;

public class PlayerController {

    private final PlayerService playerService = new PlayerService();

    public void generatePlayer() {
        playerService.initPlayer();
    }

    public int getCurrentDistance() {
        return playerService.getMovedDistance();
    }

    public String getMovingDirection() {
        try {
            String movingDirection = InputView.readMoving();
            MovingDirectionValidator.validateDirection(movingDirection);
            return movingDirection;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getMovingDirection();
        }
    }

    public void increaseMovedDistance() {
        playerService.increaseMovedDistance();
    }

    public void backToStartPoint() {
        playerService.backToStartPoint();
    }
}
