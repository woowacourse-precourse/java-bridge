package bridge.program;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeOfUser;
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
        BridgeGame bridgeGame = makeBridgeGame();
        playBridgeGame(bridgeGame);
        showBridgeGameResults(bridgeGame);
    }

    private BridgeGame makeBridgeGame() {
        int bridgeSize = consoleView.requestBridgeSize();
        List<String> bridgeMap = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridgeMap);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isDone()) {
            bridgeMove(bridgeGame);
            checkRetry(bridgeGame);
        }
    }

    private void bridgeMove(BridgeGame bridgeGame) {
        bridgeGame.move(consoleView.requestMove());
        consoleView.showNowBridge(bridgeGame.nowUserMapState());
    }

    private void checkRetry(BridgeGame bridgeGame) {
        final String RETRY_MSG = "R";
        if (bridgeGame.isFail() && consoleView.requestRetry().equals(RETRY_MSG)) {
            bridgeGame.retry();
        }
    }

    private void showBridgeGameResults(BridgeGame bridgeGame) {
        BridgeOfUser bridgeOfUser = bridgeGame.nowUserMapState();
        String failOrSuccess = bridgeGame.calculateDoneResult();
        int tryCount = bridgeGame.getTryCount();
        consoleView.showResult(bridgeOfUser,failOrSuccess,tryCount);
    }
}
