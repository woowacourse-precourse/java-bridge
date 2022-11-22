package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameCommend;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private BridgeGame game;

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
        game = new BridgeGame(buildBridge(inputController.setBridgeSize()));
    }

    private List<String> buildBridge(final int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void playGame() {
        processGame();

        if (!game.isClear()) {
            processRestart();
        }
    }

    private void processGame() {
        for (int round = 0; round < game.getStages(); round++) {
            outputView.printMap(
                game.move(round, inputController.setMovingDirection())
            );

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
