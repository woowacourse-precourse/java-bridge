package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.ExceptionTemplate;
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
            play();
        }
        output.printResult(game);
    }

    private void play() {
        while (game.checkCross() && game.movable()) {
            output.printMove();
            ExceptionTemplate template = input::readMoving;
            String inputMove = (String) template.check();
            game.move(inputMove, game.recentResult().stateSize());
            output.printMap(game.recentResult());
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
            ExceptionTemplate template = input::readGameCommand;
            return game.retry((String) template.check());
        }
        return false;
    }

    private void initGame() {
        Bridge randomBridge = makeBridge();
        output.newLine();
        game = new BridgeGame(randomBridge);
    }

    private Bridge makeBridge() {
        output.printInputBridgeSize();
        ExceptionTemplate template = () -> new Bridge(bridgeMaker.makeBridge(input.readBridgeSize()));
        return (Bridge) template.check();
    }
}
