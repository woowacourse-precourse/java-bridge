package bridge;

import bridge.application.BridgeGame;
import bridge.domain.CommandType;
import bridge.domain.Result;
import bridge.presentation.InputView;
import bridge.presentation.Message;
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
        createBridge();
        crossTheBridge();
    }

    private void createBridge() {
        try {
            int bridgeSize = InputView.readBridgeSize();
            bridgeGame.initBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_HEADER + e.getMessage());
            createBridge();
        }
    }

    private void crossTheBridge() {
        Result result;
        try {
            do {
                result = moveAndPrintMap();
            } while (!bridgeGame.isTerminate());
            checkBridgeState(result);
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_HEADER + e.getMessage());
            crossTheBridge();
        }
    }

    private Result moveAndPrintMap() {
        Result result = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(result);
        return result;
    }

    private void checkBridgeState(Result result) {
        exitIfVictoryAtGame(result);
        if (!result.isVictory()) {
            try {
                takeCommandAndExecute(result);
            } catch (IllegalArgumentException e) {
                System.out.println(Message.ERROR_HEADER + e.getMessage());
                checkBridgeState(result);
            }
        }
    }

    private void exitIfVictoryAtGame(Result result) {
        if (result.isVictory()) {
            exit(result);
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
            throw new IllegalArgumentException("유효하지 않은 명령 타입입니다.");
        }
    }

    private void exit(Result result) {
        OutputView.printResult(result);
    }
}
