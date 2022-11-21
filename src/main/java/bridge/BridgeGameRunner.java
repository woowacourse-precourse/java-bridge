package bridge;

import bridge.application.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.CommandType;
import bridge.domain.Result;
import bridge.presentation.InputView;
import bridge.presentation.OutputView;

public class BridgeGameRunner {

    private static BridgeGameRunner instance;

    private final BridgeGame bridgeGame;

    private BridgeGameRunner() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = BridgeGame.createInstance(bridgeMaker);
    }

    public static BridgeGameRunner getInstance() {
        if (instance == null) {
            instance = new BridgeGameRunner();
        }
        return instance;
    }

    public void run() {
        int bridgeSize = InputView.readBridgeSize();
        bridgeGame.initBridge(bridgeSize);

        crossTheBridge();
    }

    private void crossTheBridge() {
        Result result;
        do {
            result = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(result);
        } while (!bridgeGame.isTerminate());
        checkBridgeState(result);
    }

    private void checkBridgeState(Result result) {
        if (result.isVictory()) {
            exit(result);
        }
        if (!result.isVictory()) {
            takeCommandAndExecute(result);
        }
    }

    private void takeCommandAndExecute(Result result) {
        String command = InputView.readGameCommand();
        validateCommand(command);
        if (command.equals(CommandType.R.name())) {
            bridgeGame.retry();
            crossTheBridge();
        }
        if (command.equals(CommandType.Q.name())) {
            exit(result);
        }
    }

    private void validateCommand(String command) {
        if (!CommandType.getNames().contains(command)) {
            throw new IllegalStateException("유효하지 않은 명령 타입입니다.");
        }
    }

    private void exit(Result result) {
        OutputView.printResult(result);
    }
}
