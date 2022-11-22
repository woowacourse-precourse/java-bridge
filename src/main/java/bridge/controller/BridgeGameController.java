package bridge.controller;

import bridge.domain.direction.Direction;
import bridge.domain.factory.BridgeGameFactory;
import bridge.domain.game.BridgeGame;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.command.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String INITIAL_START_COMMAND = "R";
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
        BridgeGameFactory bridgeGameFactory = new BridgeGameFactory();
        return bridgeGameFactory.createBridgeGame(inputView.readBridgeSize());
    }

    private void play(BridgeGame bridgeGame, Pedestrian pedestrian) {
        Command command = initializeCommand();
        while (!bridgeGame.isEndLocation(pedestrian) && isPlayingStatus(command)) {
            executeMove(bridgeGame, pedestrian);

            if (pedestrian.hasIncorrectDirection()) {
                command = new Command(inputView.readGameCommand());
                executeRetry(bridgeGame, pedestrian, command);
            }
        }
    }

    private void executeMove(BridgeGame bridgeGame, Pedestrian pedestrian) {
        Direction direction = new Direction(inputView.readMoving());
        bridgeGame.move(pedestrian, direction);
        outputView.printMap(pedestrian.createMovingRecord());
    }

    private void executeRetry(BridgeGame bridgeGame, Pedestrian pedestrian, Command command) {
        if (isPlayingStatus(command)) {
            bridgeGame.retry(pedestrian);
        };
    }

    private boolean isPlayingStatus(Command command) {
        return command.isToRetryGame();
    }

    private Command initializeCommand() {
        return new Command(INITIAL_START_COMMAND);
    }
}
