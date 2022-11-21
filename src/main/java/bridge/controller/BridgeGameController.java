package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameCommand;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(BridgeMaker bridgeMaker) {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printInit();
        Bridge bridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.initialize();
        Player player = new Player();
        while (bridgeGame.isContinuing()) {
            player = new Player();
            play(player, bridgeGame);
            if (bridgeGame.isPlayerDead()) {
                String gameCommand = inputView.readGameCommand();
                bridgeGame.retry(GameCommand.toGameCommand(gameCommand));
            }
        }
        outputView.printResult(player, bridgeGame);
    }

    private Bridge makeBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeMaker.constructBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makeBridge();
        }
    }

    private void play(Player player, BridgeGame bridgeGame) {
        while (bridgeGame.isContinuing()) {
            movePlayer(player, bridgeGame);
            outputView.printMap(player);
        }
    }

    private void movePlayer(Player player, BridgeGame bridgeGame) {
        try {
            String moving = inputView.readMoving();
            bridgeGame.move(player, moving);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            movePlayer(player, bridgeGame);
        }
    }
}
