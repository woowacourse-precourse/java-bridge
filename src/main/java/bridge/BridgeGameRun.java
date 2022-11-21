package bridge;

import java.util.List;

public class BridgeGameRun {

    private final InputView inputView;
    private final InputValidation inputValidation;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private boolean result;

    public BridgeGameRun(InputView inputView, InputValidation inputValidation, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
        this.outputView = outputView;
    }

    private void bridgeGameGenerate(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    private void bridgeGameStart() {
        do {
            String direct = inputView.readMoving();
            inputValidation.readMovingValidation(direct);
            gameRun(direct);

            List<List<String>> bridgeMap = bridgeGame.getBridgeMap();
            outputView.printMap(bridgeMap);

        } while (!isGameEnd());
    }

    private boolean isRetry() {
        String command = inputView.readGameCommand();
        inputValidation.readGameCommandValidation(command);

        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
