package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;

import java.util.List;

public class BridgeService {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startService() {
        initService();
        playBridgeGame();

        if (checkRestart()) {
            startService();
        }
    }

    private void initService() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame.initGame(bridge);
    }

    private void playBridgeGame() {
        boolean fail = true;

        do {
            fail = playOneTurn();
        } while (!isGameEnd(fail));

        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getCurStep(), fail);
    }

    private boolean playOneTurn() {
        boolean fail;

        String moving = inputView.readMoving();
        fail = !bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getCurStep(), fail);

        return fail;
    }

    private boolean isGameEnd(boolean fail) {
        return fail || bridgeGame.isFinished();
    }

    private boolean checkRestart() {
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }
}
