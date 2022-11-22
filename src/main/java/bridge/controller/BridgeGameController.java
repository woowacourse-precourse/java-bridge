package bridge.controller;

import bridge.domain.direction.Direction;
import bridge.domain.factory.BridgeGameFactory;
import bridge.domain.game.BridgeGame;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.command.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String START_COMMAND = "R";
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGameMain() {
        try {
            runBridgeGame();
        } catch (RuntimeException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void runBridgeGame() {
        outputView.printStart();
        Pedestrian pedestrian = new Pedestrian();
        BridgeGame bridgeGame = createBridgeGame();

        play(bridgeGame, pedestrian);

        outputView.printResult(pedestrian.createMovingRecord(), bridgeGame.isEndLocation(pedestrian), bridgeGame.createRound());
    }

    private BridgeGame createBridgeGame() {
        while(true) {
            try {
                BridgeGameFactory bridgeGameFactory = new BridgeGameFactory();
                return bridgeGameFactory.createBridgeGame(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void play(BridgeGame bridgeGame, Pedestrian pedestrian) {
        Command command = initializeStartCommand();
        while (!bridgeGame.isEndLocation(pedestrian) && isPlaying(command)) {
            executeMove(bridgeGame, pedestrian);

            if (pedestrian.hasIncorrectDirection()) {
                command = inputCommand();
                executeRetry(bridgeGame, pedestrian, command);
            }
        }
    }

    private Command inputCommand() {
        while(true) {
            try {
                return new Command(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void executeMove(BridgeGame bridgeGame, Pedestrian pedestrian) {
        Direction direction = inputDirection();
        bridgeGame.move(pedestrian, direction);
        outputView.printMap(pedestrian.createMovingRecord());
    }

    private Direction inputDirection() {
        while(true) {
            try {
                return new Direction(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void executeRetry(BridgeGame bridgeGame, Pedestrian pedestrian, Command command) {
        if (isPlaying(command)) {
            bridgeGame.retry(pedestrian);
        };
    }

    private boolean isPlaying(Command command) {
        return command.isToRetryGame();
    }

    private Command initializeStartCommand() {
        return new Command(START_COMMAND);
    }
}
