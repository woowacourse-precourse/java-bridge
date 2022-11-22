package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame game;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.game = new BridgeGame();
    }

    public void run() {
        init();
        process();
        getResult();
    }

    private void init() {
        outputView.printStart();
        while (true) {
            try {
                outputView.printLengthCommand();
                game.init(inputView.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void process() {
        while (true) {
            if (isExit()) {
                break;
            }
            if (game.isEnd()) {
                break;
            }
        }
    }

    private boolean isExit() {
        if(move()) {
            return false;
        }
        outputView.printReStart();
        while (true) {
            try {
                return !retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean move() {
        boolean success;
        while (true) {
            try {
                outputView.printMovingCommand();
                success = game.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.printMap(game.convertBridge());
        return success;
    }

    private boolean retry(String command) {
        while (true) {
            try {
                return game.retry(command);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getResult() {
        outputView.printResult(game.convertBridge(), game.getSuccess(), game.getTotalTryNumber());
    }
}
