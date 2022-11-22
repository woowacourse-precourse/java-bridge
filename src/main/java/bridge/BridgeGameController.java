package bridge;

import static bridge.constant.GameCommand.RETRY;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private BridgeGame bridgeGame;

    public void play() {
        outputView.printGameStartMessage();
        List<String> bridge = initialBridge();
        bridgeGame = new BridgeGame(bridge);
        processGame();
        outputView.printResult(bridgeGame);
    }

    private List<String> initialBridge() {
        int bridgeSize = inputBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private int inputBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }

    private void processGame() {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean roundResult = playRound();
            if (!roundResult) {
                gameCommand();
                break;
            }
        }
    }

    private boolean playRound() {
        String moving = inputMoving();
        boolean result = bridgeGame.move(moving);
        outputView.printMap(bridgeGame);
        return result;
    }

    private String inputMoving() {
        outputView.printMovingInputMessage();
        return inputView.readMoving();
    }

    private void gameCommand() {
        outputView.printGameCommandInputMessage();
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(RETRY)) {
            retry();
        }
    }

    private void retry() {
        bridgeGame.retry();
        processGame();
    }
}
