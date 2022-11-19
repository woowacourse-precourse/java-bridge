package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.view.Message.*;

public class BridgeGameService {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void init() {
        outputView.printStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    public void start() {
        do {
            bridgeMoving();
        } while (!isGameFinish() && !isGameEnd());
        outputView.printResult(bridgeGame.getResult(), bridgeGame.isSuccess(), bridgeGame.getGameCount());
    }

    private void bridgeMoving() {
        outputView.printOf(MESSAGE_INPUT_BRIDGE_MOVING.getMessage());
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getResult());
    }

    private boolean isGameFinish() {
        return bridgeGame.isFinishBridge();
    }

    private boolean isGameEnd() {
        if (bridgeGame.isGameEnd()) {
            return !isRetry();
        }
        return false;
    }

    private boolean isRetry() {
        return bridgeGame.retry(selectRetryOrExit());
    }

    private String selectRetryOrExit() {
        outputView.printOf(MESSAGE_RETRY_OR_EXIT.getMessage());
        return inputView.readGameCommand();
    }
}
