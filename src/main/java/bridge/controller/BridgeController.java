package bridge.controller;

import bridge.GameCommend;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private BridgeGameService game;

    private final InputController inputController;

    private final OutputView outputView;

    public BridgeController() {
        inputController = new InputController(new InputView());
        outputView = new OutputView();
    }

    public void start() {
        setUpBridge();
        playGame();
        printResult();
    }

    private void setUpBridge() {
        game = new BridgeGameService(inputController.setBridgeSize());
    }

    private void playGame() {
        processGame();

        if (!game.isClear()) {
            processRestart();
        }
    }

    private void processGame() {
        while (!game.isClear()) {
            outputView.printMap(game.move(inputController.setMovingDirection()));

            if (game.isOver()) {
                break;
            }
        }
    }

    private void processRestart() {
        GameCommend commend = inputController.setGameCommend();

        if (commend.isRestart()) {
            resetGame();
            playGame();
        }
    }

    private void resetGame() {
        game.retry();
        outputView.clearMap();
    }

    private void printResult() {
        outputView.printResult(game.isClear(), game.getAttempts());
    }
}
