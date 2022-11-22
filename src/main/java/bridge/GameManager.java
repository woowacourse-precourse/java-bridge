package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {
    private final BridgeGame bridgeGame;
    private final Bridge bridge;

    public GameManager(BridgeMaker bridgeMaker) {
        OutputView.printGameStartMessage();
        bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        boolean status;
        do {
            status = moveForward();
        } while (status);

        if(status && isRetry()) {
            play();
            return;
        }
        OutputView.printResult(bridgeGame);
    }

    private boolean moveForward() {
        for(int i =0; i < bridge.size(); i++) {
            bridgeGame.setPosition(i);
            String input = InputView.readMoving();
            bridgeGame.move(input);
            OutputView.printMap(bridgeGame);
            if(!bridgeGame.isCorrect(input)) {
                return false;
            }
        }
        return false;
    }

    private boolean isRetry() {
        if (Key.matchEnd(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}
