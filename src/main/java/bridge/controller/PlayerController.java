package bridge.controller;

import bridge.service.PlayerService;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class PlayerController {
    private final static String RESTART_GAME = "R";

    private final PlayerService playerService = new PlayerService();

    public void generatePlayer() {
        playerService.initPlayer();
    }

    public int getCurrentDistance() {
        return playerService.getAndIncreaseMovedDistance();
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

    private String getGameCommand() {
        String input = InputView.readGameCommand();
        try {
            GameCommandValidator.validateCommand(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getGameCommand();
        }
    }

    public boolean retryGame() {
        boolean retryGame = getGameCommand().equals(RESTART_GAME);
        if (retryGame) {
            playerService.backToStartPoint();
        }
        return retryGame;
    }

    public void printGameStatics() {
        int attemptCount = playerService.getAttemptCount();
        OutputView.printGameStatics(attemptCount);
    }
}
