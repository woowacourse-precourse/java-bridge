package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Enum.Result.*;

public class BridgeGameController {
    private final ConsoleController consoleController;
    private final BridgeMaker bridgeMaker;

    private List<String> bridgeScaffold;

    public BridgeGameController(ConsoleController consoleController, BridgeMaker bridgeMaker) {
        this.consoleController = consoleController;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        int bridgeSize = initBridge();

        BridgeGame bridgeGame = new BridgeGame(bridgeScaffold);

        List<String> finalResult = bridgeGameLoop(bridgeGame, bridgeSize);

        consoleController.outputFinalResult(finalResult);
    }

    private int initBridge() {

        int bridgeSizeInput = consoleController.inputBridgeSize();

        this.bridgeScaffold = bridgeMaker.makeBridge(bridgeSizeInput);

        return bridgeSizeInput;
    }

    private List<String> bridgeGameLoop(BridgeGame bridgeGame, int bridgeSize) {
        for (int count = 1; ; count++) {
            List<String> crossBridgeResult = crossBridge(bridgeGame, bridgeSize);

            if (checkGameEnd(crossBridgeResult.get(0))) {
                crossBridgeResult.add(String.valueOf(count));
                return crossBridgeResult;
            }
            bridgeGame.retry();
        }
    }

    private boolean checkGameEnd(String gameResult) {
        if (gameResult.equals(SURVIVE.getSign())) {
            return true;
        }
        return isCommandQuit();
    }

    private List<String> crossBridge(BridgeGame bridgeGame, int bridgeSize) {
        List<String> stepResult = new ArrayList<>();

        for (int i = 0; i < bridgeSize; i++) {
            stepResult = moveOneStep(bridgeGame);

            if ((FAIL.getSign()).equals(stepResult.get(0))) {
                return stepResult;
            }
        }
        return stepResult;
    }

    private List<String> moveOneStep(BridgeGame bridgeGame) {
        String direction = consoleController.inputMovingDirection();

        List<String> stepResult = bridgeGame.move(direction);

        List<String> stepProgress = stepResult.subList(1, 3);
        consoleController.outputStepProgress(stepProgress);

        return stepResult;
    }

    private boolean isCommandQuit() {
        final String QUIT_COMMAND = "Q";

        String gameCommand = consoleController.inputGameCommand();

        return QUIT_COMMAND.equals(gameCommand);
    }

}
