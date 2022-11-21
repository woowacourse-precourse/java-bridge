package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.BridgeGameStatus;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final BridgeGame bridgeGame = new BridgeGame(bridgeNumberGenerator);
        initializeGame(bridgeGame);
        playGame(bridgeGame);
        terminateGame(bridgeGame);
    }

    private static void initializeGame(BridgeGame bridgeGame) {
        outputView.printGameStartMessage();
        final int bridgeSize = inputView.readBridgeSize();
        bridgeGame.initialize(bridgeSize);
    }

    private static void playGame(BridgeGame bridgeGame) {
        do {
            run(bridgeGame);
            final BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
            if (bridgeGameStatus.isGameSuccessfulEnd()) break;
        } while (bridgeGame.retry(inputRetryCommand()));
    }

    private static void run(BridgeGame bridgeGame) {
        bridgeGame.addRunCount();
        do {
            final Moving nowMoving = inputView.readMoving();
            bridgeGame.move(nowMoving);
            final BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
            outputView.printMap(bridgeGameStatus);
        } while (bridgeGame.canMoveContinue());
    }

    private static GameCommand inputRetryCommand() {
        return inputView.readGameCommand();
    }

    private static void terminateGame(BridgeGame bridgeGame) {
        BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();
        outputView.printResult(bridgeGameStatus);
    }
}
