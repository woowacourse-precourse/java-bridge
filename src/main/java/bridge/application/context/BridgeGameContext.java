package bridge.application.context;

import bridge.BridgeMaker;
import bridge.application.config.BridgeGameConfig;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.CrossStatus;
import bridge.domain.command.GameCommand;
import bridge.domain.direction.Direction;
import bridge.domain.game.BridgeGame;
import bridge.domain.trycount.TryCount;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameContext {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private TryCount tryCount;
    private BridgeGame bridgeGame;

    public BridgeGameContext(final BridgeGameConfig config) {
        this.inputView = config.inputView();
        this.outputView = config.outputView();
        this.bridgeMaker = config.bridgeMaker();
        this.tryCount = TryCount.start();
    }

    public void printStart() {
        outputView.printStartMessage();
    }

    public void requestInputBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        this.bridgeGame = new BridgeGame(Bridge.fromStrings(bridge));
    }

    public CrossStatus requestCrossBridge() {
        String input = inputView.readMoving();

        Direction direction = Direction.ofSymbol(input);

        CrossStatus status = this.bridgeGame.move(direction);

        outputView.printMap(bridgeGame.currentMap());

        return status;
    }

    public GameCommand requestInputRetry() {
        String input = inputView.readGameCommand();
        return GameCommand.of(input);
    }

    public void retry() {
        bridgeGame.retry();
        tryCount = tryCount.up();
    }

    public void showResult() {
        outputView.printResult(tryCount,
                bridgeGame.status(),
                bridgeGame.currentMap());
    }
}
