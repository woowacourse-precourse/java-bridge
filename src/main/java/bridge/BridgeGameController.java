package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> bridgeScaffold;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        int bridgeSize = initBridge();

        BridgeGame bridgeGame = new BridgeGame(bridgeScaffold);

        List<String> finalResult = bridgeGameLoop(bridgeGame, bridgeSize);
        outputView.printResult(finalResult);
    }

    private int initBridge() {
        outputView.printGameStart();

        int bridgeSizeInput = inputView.readBridgeSize();

        this.bridgeScaffold = bridgeMaker.makeBridge(bridgeSizeInput);

        return bridgeSizeInput;
    }

    private List<String> bridgeGameLoop(BridgeGame bridgeGame, int bridgeSize) {
        for (int i = 1; ; i++) {
            List<String> crossBridgeResult = crossBridge(bridgeGame, bridgeSize);

            if (checkGameEnd(crossBridgeResult.get(0))) {
                crossBridgeResult.add(String.valueOf(i));
                return crossBridgeResult;
            }
            bridgeGame.retry();
        }
    }

    private boolean checkGameEnd(String gameResult) {
        if ("O".equals(gameResult)) {
            return true;
        }
        return isCommandQuit();
    }

    private List<String> crossBridge(BridgeGame bridgeGame, int bridgeSize) {
        List<String> stepResult = new ArrayList<>();

        for (int i = 0; i < bridgeSize; i++) {
            stepResult = moveOneStep(bridgeGame);
            if ("X".equals(stepResult.get(0))) {
                return stepResult;
            }
        }
        return stepResult;
    }

    private List<String> moveOneStep(BridgeGame bridgeGame) {
        outputView.printDirectionInput();

        String direction = inputView.readMoving();

        List<String> movingProgress = bridgeGame.move(direction);

        outputView.printMap(movingProgress.subList(1, 3));

        return movingProgress;
    }

    private boolean isCommandQuit() {
        outputView.printGameCommandInput();

        String gameCommand = inputView.readGameCommand();

        return "Q".equals(gameCommand);
    }

}
