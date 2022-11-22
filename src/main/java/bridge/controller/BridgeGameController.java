package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameStatus;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import bridge.validator.InputValidator;

public class BridgeGameController {
    InputView input;
    OutputView output;
    private Bridge bridge;
    private BridgeGame game;


    public BridgeGameController() {
        this.input = new InputView();
        this.output = new OutputView();
    }

    public void startNewGame() {
        while (true) {
            try {
                startGameByInputSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void runGame() {
        while (game.currentStatus.equals(GameStatus.CONTINUE)) {
            play();
            if (game.currentStatus.equals(GameStatus.FAIL)) {
                retryOrEndGame();
            } if (game.currentStatus.equals(GameStatus.SUCCESS)) {
                output.printResult(game);
            }
        }
    }

    public void play() {
        while (true) {
            try {
                moveByInputDirection();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void retryOrEndGame() {
        while (true) {
            try {
                retryOrEndGameByInputCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startGameByInputSize() {
        int size = input.readBridgeSize();
        this.bridge = new Bridge(size);
        this.game = new BridgeGame(bridge);
    }

    public void moveByInputDirection() {
        String direction = input.readMoving();
        game.move(direction);
        output.printMap(bridge);
    }

    public void retryOrEndGameByInputCommand() {
        String gameCommand = input.readGameCommand();
        if (gameCommand.equals("R")) {
            game.retry();
        }
        if (gameCommand.equals("Q")) {
            output.printResult(game);
        }
    }
}
