package bridge.program;

import bridge.domain.BridgeMaker;
import bridge.domain.common.BridgeRandomNumberGenerator;
import bridge.view.ConsoleView;
import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeGameProgram {
    private final ConsoleView consoleView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameProgram() {
        this.consoleView = new ConsoleView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        consoleView.showGameStart();

        List<String> bridgeMap = bridgeMaker.makeBridge(consoleView.requestBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);

        while (bridgeGame.isNotDone()) {
            bridgeGame.move(consoleView.requestMove());
            consoleView.showNowBridge(bridgeGame.nowUserMapState());

            if (bridgeGame.isFail()) {
                String s = consoleView.requestRetry();
                if (s.equals("R")) {
                    bridgeGame.retry();
                }
            }
        }
        consoleView.showResult(bridgeGame.nowUserMapState(), bridgeGame.failOrSuccess(), bridgeGame.getTryCount());
    }
}
