package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class BridgeGameController implements GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker bridgeMaker;
    private BridgeGame game;

    public BridgeGameController(BridgeNumberGenerator generator) {
        this.bridgeMaker = new BridgeMaker(generator);
        this.game = new BridgeGame();
    }

    @Override
    public void start() {
        output.printStart();
        initGame();
        while (game.state()) {
            game.newResult();
            play();
        }
        output.printResult(game);
    }

    @Override
    public void play() {
        int crossCount = 0;
        while (!game.isBridgeLength(crossCount) && game.crossState()) {
            output.printMove();
            String inputMove = input.readMoving();
            game.move(inputMove, crossCount);
            output.printMap(game.recentResult());
            crossCount++;
        }
        end(checkRestart());
    }

    private void end(boolean restart) {
        if (restart) {
            play();
        }
        game.end();
    }

    private boolean checkRestart() {
        if (!game.recentResult().movable()) {
            output.printRestart();
            String inputMove = input.readGameCommand();
            return game.retry(inputMove);
        }
        return false;
    }

    private void initGame() {
        Bridge randomBridge = makeBridge();
        game = new BridgeGame(randomBridge);
    }

    private Bridge makeBridge() {
        output.printInputBridgeSize();
        while (true) {
            try {
                int bridgeSize = input.readBridgeSize();
                return new Bridge(bridgeMaker.makeBridge(bridgeSize));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
