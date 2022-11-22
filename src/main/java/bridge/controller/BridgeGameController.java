package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.ExceptionTemplate;
import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.service.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

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
            ExceptionTemplate template = () -> {
                String command = input.readCommand();
                int crossCount = game.recentResult().stateSize();
                return game.move(command, crossCount);
            };
            output.printMap((Result) template.check());
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
            ExceptionTemplate template = () -> {
                String command = input.readCommand();
                return game.retry(command);
            };
            return (boolean) template.check();
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
        ExceptionTemplate template = () -> {
            int bridgeSize = input.readBridgeSize();
            List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
            return new Bridge(randomBridge);
        };
        return (Bridge) template.check();
    }
}
