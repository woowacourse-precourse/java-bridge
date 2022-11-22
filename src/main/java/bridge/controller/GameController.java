package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.player.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final BridgeMaker bridgeMaker;
    private final Player player;
    private BridgeGame bridgeGame;

    public GameController(Player player, BridgeMaker bridgeMaker) {
        this.player = player;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        Bridge bridge = initializeBridge();
        play(bridge);
        printResult();
    }

    private Bridge initializeBridge() {
        outputView.printStart();
        int size = inputView.readBridgeSize();
        return Bridge.of(size, bridgeMaker);
    }

    private void play(Bridge bridge) {
        do {
            initializeGame(bridge);
            move(bridge.getBridgeSize());
            bridgeGame.retry();
            if (bridgeGame.isMovable) {
                return;
            }
        } while (inputView.readGameCommand().isRetry());
    }

    private void initializeGame(Bridge bridge) {
        bridgeGame = BridgeGame.of(bridge, player);
    }

    private void move(int size) {
        do {
            player.addMoving(inputView.readMoving());
            outputView.printMap(bridgeGame.move());
        } while (bridgeGame.isMovable && !player.isFull(size));
    }

    private void printResult() {
        outputView.printResultMap(bridgeGame.getMap());
        outputView.printResult(player.getTryCount(), bridgeGame.isMovable);
    }
}
