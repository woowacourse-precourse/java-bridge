package bridge;

import bridge.domain.bridge.BridgeDirection;
import bridge.domain.game.BridgeGame;
import bridge.domain.bridge.BridgeMap;
import bridge.domain.game.GamePlayer;
import bridge.ui.input.InputView;
import bridge.ui.output.OutputView;
import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void launchGame() {
        outputView.printInitMessage();
    }

    public BridgeMap generateBridgeGameMap(BridgeNumberGenerator generator) {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return BridgeMap.from(bridge);
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize().toInteger();
    }

    public void playGame(BridgeMap bridgeMap) {
        BridgeGame bridgeGame = setupGame(bridgeMap);

        do {
            BridgeDirection bridgeDirection = readBridgeDirection();
            bridgeGame.move(bridgeDirection);
            outputView.printMap(bridgeGame.toBridgeGameMapState());
        } while (isPlayable(bridgeGame));

        outputView.printResult(bridgeGame.toBridgeGameResult());
    }

    private BridgeGame setupGame(BridgeMap bridgeMap) {
        GamePlayer gamePlayer = GamePlayer.withDefaultValue();
        return BridgeGame.of(bridgeMap, gamePlayer);
    }

    private BridgeDirection readBridgeDirection() {
        return inputView.readMoving().toBridgeDirection();
    }

    private boolean isPlayable(BridgeGame bridgeGame) {
        if (bridgeGame.isFailGame()) {
            return isRestart(bridgeGame);
        }

        return !bridgeGame.isCrossedBridge();
    }

    private boolean isRestart(BridgeGame bridgeGame) {
        boolean restart = inputView.readGameCommand().isRestart();
        if (restart) {
            bridgeGame.retry();
        }
        return restart;
    }
}
