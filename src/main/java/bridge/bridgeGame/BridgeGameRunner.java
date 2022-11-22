package bridge.bridgeGame;

import bridge.bridge.BridgeNumberGenerator;
import bridge.bridge.BridgePosition;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameRunner {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameRunner(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeGame = new BridgeGame(bridgeNumberGenerator);
    }

    private void initGame() {
        outputView.printInitGameMessage();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }

    private RoundResult runRound() {
        while (!bridgeGame.isEnded()) {
            outputView.printRequestBridgeMoving();
            BridgePosition bridgePosition = inputView.readMoving();
            bridgeGame.move(bridgePosition);
            outputView.printMap(bridgeGame.getBridgeGameState());
        }
        return checkRoundResult();
    }

    private RoundResult checkRoundResult() {
        if (bridgeGame.isWon()) {
            return RoundResult.END;
        }
        return checkRetry();
    }

    private RoundResult checkRetry() {
        outputView.printRequestGameRetry();
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(InputView.GAME_RESTART)) {
            return RoundResult.CONTINUE;
        }
        return RoundResult.END;
    }
}
