package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void bridgeGameStart() {
        try {
            BridgeGame bridgeGame = createBridgeGame();

            playBridgeGame(bridgeGame);

            GameOver(bridgeGame.getPlayer());
        } catch (RuntimeException exception) {
            outputView.printError(exception);
        }
    }

    private BridgeGame createBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridge);
    }

    private void GameOver(Player player) {
        outputView.printResult(player);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        while(true) {
            move(bridgeGame);

            if(!checkIsPossible(bridgeGame)) {
                break;
            }

            if(checkGameSuccess(bridgeGame)) {
                break;
            }
        }
    }

    private boolean checkIsPossible(BridgeGame bridgeGame) {
        if(bridgeGame.isCanCross()) {
            outputView.printMap(bridgeGame.getPlayer());
            return true;
        }

        bridgeGame.failGame();
        outputView.printMap(bridgeGame.getPlayer());
        if (restartOrExit(bridgeGame)) {
            return false;
        }
        return true;
    }

    private void move(BridgeGame bridgeGame) {
        String movingSpace = inputView.readMoving();
        bridgeGame.move(movingSpace);
    }

    private boolean checkGameSuccess(BridgeGame bridgeGame) {
        if(bridgeGame.isGameSuccess()) {
            return true;
        }
        return false;
    }

    private boolean restartOrExit(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }

}