package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private BridgeGame game;

    private final InputView inputView;

    private final OutputView outputView;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        setUpBridge();
        playGame();
        printResult();
    }

    private void setUpBridge() {
        game = new BridgeGame(buildBridge(inputView.readBridgeSize()));
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
            String direction = inputView.readMoving();
            outputView.printMap(direction, game.move(round, direction));

            if (game.isOver()) {
                break;
            }
        }
    }

    private void processRestart() {
        String commend = inputView.readGameCommand();

        if ("R".equals(commend)) {
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
