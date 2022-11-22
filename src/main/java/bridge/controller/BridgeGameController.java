package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Command;
import bridge.Message;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = createBridgeGame();
    }

    public void play() {
        Message.START.print();

        move();
        while (!bridgeGame.isEnd() && isRetry()) {
            bridgeGame.retry();
            move();
        }
        end();
    }

    private void end() {
        outputView.printResult(bridgeGame);
    }

    private boolean isRetry() {
        String command = inputView.readGameCommand();
        return command.equals(Command.RETRY.getCommand());
    }

    private BridgeGame createBridgeGame() {
        Bridge bridge = createBridge();
        Player player = createPlayer();
        return new BridgeGame(bridge, player);
    }

    private Player createPlayer() {
        List<String> map = new ArrayList<>();
        int gameAttempts = 1;
        return new Player(map, gameAttempts);
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = createBridgeMaker();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridge);
    }

    private BridgeMaker createBridgeMaker() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeRandomNumberGenerator);
    }

    private void move() {
        do {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame);
        } while (!bridgeGame.isLastMovedFailure() && !bridgeGame.isEnd());
    }
}
